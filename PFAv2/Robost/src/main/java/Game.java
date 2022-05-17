import entities.CircularArray;
import entities.Node;
import entities.Pair;
import pieces.Intruder;
import pieces.Piece;
import pieces.Robot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    //The length of the board
    private final int length;
    //The width of the board
    private final int width;
    //The board with dimensions length * width. It contains -1 if the space is empty
    //Otherwise it returns the index of the piece in the list of pieces
    public int[][] board;
    public List<Piece> pieces = new ArrayList<>();

    //Parameters for the GI window
    private final String GAME_NAME = "Robots";
    //dimensions of the window
    private final int SCREEN_HEIGHT = 500;
    private final int SCREEN_WIDTH = 800;
    //dimensions of the render area
    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = 700;

    private final int waitTime = 3000;
    public FenetreGraphique window;

    private final int tileHeight;
    private final int tileWidth;


    public Game(int length, int width, boolean GUI) {
        this.length = length;
        this.width = width;
        this.tileHeight = (WINDOW_HEIGHT - 1) / width;
        this.tileWidth = (WINDOW_WIDTH - 1) / length;
        board = new int[length][width];
        if(GUI){
            window = new FenetreGraphique(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, WINDOW_WIDTH, WINDOW_HEIGHT, GAME_NAME);
        }
        initialize();
    }

    public void initialize() {
        //We set every spot of the board as being empty
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = -1;
            }
        }
    }

    //If the piece to be added is a robot, we add it at index 0, so Robots are always first
    public void addPiece(Piece p) {
        if (p instanceof Robot) {
            pieces.add(0, p);
        } else {
            pieces.add(p);
        }
        //The move function works better if we move the robots first, and then the intruders. So we make sure the list is sorted
        Collections.sort(pieces);
    }

    //Places the given ID of a piece on the board, at the given coordinates
    public void set(int x, int y, int p) {
        board[x][y] = p;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

    //We iterate over all pieces, checking no two pieces start on the same space
    public boolean differentSpots() {
        for (int i = 0; i < pieces.size(); i++) {
            Piece p = pieces.get(i);
            if (!p.getCoords().isInBonds(length, width)) {
                continue;
            }
            for (int j = i + 1; j < pieces.size(); j++) {
                Piece q = pieces.get(j);
                if (!q.getCoords().isInBonds(length, width)) {
                    continue;
                }
                if (p.getCoords().compare(q.getCoords())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void playTurn() {
        for (Piece p : pieces) {
            p.setMoved(false);
        }
        boolean movedSmth = true;
        while (movedSmth) {
            movedSmth = movePieces();
        }
    }

    //This function assumes the list of pieces contains first the robots, and then the intruders
    //We expect this function to be called as long as at least 1 piece moves each time
    public boolean movePieces() {
        boolean movedSmth = false;
        for (int index = 0; index < pieces.size(); index++) {
            Piece p = pieces.get(index);
            //We only try to move if the piece has not already moved this turn
            if (p.hasMoved()) {
                continue;
            }
            if (p instanceof Robot robot) {
                movedSmth = movedSmth || moveRobot(robot, index);
            }
            if (p instanceof Intruder intruder) {
                movedSmth = movedSmth || moveIntruder(intruder, index);
            }
        }
        return movedSmth;
    }

    public boolean moveRobot(Robot p, int index) {
        boolean movedSmth = false;
        Pair coords = p.getCoords();
        Pair nextCoords = p.nextCoords();
        //If the space we want to move on is empty, the piece moves
        if (get(nextCoords.getX(), nextCoords.getY()) == -1) {
            set(coords.getX(), coords.getY(), -1);
            set(nextCoords.getX(), nextCoords.getY(), index);
            p.move();
            movedSmth = true;
        } else {
            //Else, space is not empty, we check what occupies the space
            Piece otherPiece = pieces.get(get(nextCoords.getX(), nextCoords.getY()));
            //If it is something that already moved this turn
            if (otherPiece.hasMoved()) {
                //And it is an intruder that has already moved, hence we capture it
                if (otherPiece instanceof Intruder intruder) {
                    intruder.setCaught(true);
                    set(coords.getX(), coords.getY(), -1);
                    set(nextCoords.getX(), nextCoords.getY(), index);
                    p.move();
                    movedSmth = true;
                    //Else it is a robot, then we will not be able to move this turn
                } else {
                    p.setMoved(true);
                }
                //Else the space is occupied by something which hasn't moved yet, hence we wait
            }
        }
        return movedSmth;
    }


    public boolean moveIntruder(Intruder p, int index) {
        boolean movedSmth = false;
        //We only try to move if the piece has not been caught nor reached the end of its list of coordinates
        if (!p.gotCaught() && !p.hasEscaped()) {
            Pair coords = p.getCoords();
            Pair nextCoords = p.nextCoords();
            if (null == nextCoords) {
                p.setOnBoard(false);
                p.setEscaped(true);
                set(coords.getX(), coords.getY(), -1);
                return true;
            }
            //If the next move goes outside the board, the intruder disappears
            if (!nextCoords.isInBonds(length, width)) {
                if (p.isOnBoard()) {
                    set(coords.getX(), coords.getY(), -1);
                }
                p.setOnBoard(false);
                p.move();
                movedSmth = true;
                //Else, if the next space is empty, we move on
            } else if (get(nextCoords.getX(), nextCoords.getY()) == -1) {
                if (p.isOnBoard()) {
                    set(coords.getX(), coords.getY(), -1);
                }
                set(nextCoords.getX(), nextCoords.getY(), index);
                p.setOnBoard(true);
                p.move();
                movedSmth = true;
                //Else we're trying to get to an occupied space
            } else {
                //We check what occupies the space
                Piece otherPiece = pieces.get(get(nextCoords.getX(), nextCoords.getY()));
                //If it is something that already moved this turn
                if (otherPiece.hasMoved()) {
                    //And it is a robot, then we get caught
                    if (otherPiece instanceof Robot) {
                        p.setCaught(true);
                        if (p.isOnBoard()) {
                            set(coords.getX(), coords.getY(), -1);
                        }
                        p.setOnBoard(true);
                        p.move();
                        movedSmth = true;
                        //Else it is an intruder that has already moved, so we won't be able to move this turn
                    } else {
                        if (p.isOnBoard()) {
                            set(coords.getX(), coords.getY(), -1);
                        }
                        set(nextCoords.getX(), nextCoords.getY(), index);
                        p.setOnBoard(true);
                        p.move();
                        movedSmth = true;
                    }
                    //Else the space is occupied by something which hasn't moved yet, hence we wait
                }
            }
        }
        return movedSmth;
    }

    public boolean validPieces() {
        //We must have at least two robots, so at least two elements
        if (null == pieces || pieces.size() < 2) {
            System.out.println("There are not enough pieces");
            return false;
        }
        //We check those two (at minima) elements are robots
        if (!(pieces.get(0) instanceof Robot & pieces.get(1) instanceof Robot)) {
            System.out.println("There are not enough robots (need at least 2)");
            return false;
        }
        return true;
    }

    //Duplicate of the function circuitIsValid of the Robot class, to check if a given CircularArray will be accepted or not
    public boolean circuitForRobot(int length, int width, CircularArray ca) {
        if (null == ca || null == ca.getHead() || null == ca.getHead().getNext() || ca.getHead().getNext() == ca.getHead()) {
            return false;
        }
        Node currenti = ca.getHead().getNext();
        Node currentj = ca.getHead();
        if (!currentj.getPair().isNextTo(currenti.getPair()) || !currentj.getPair().isInBonds(length, width) || !currenti.getPair().isInBonds(length, width)) {
            return false;
        }
        //A boolean so that we only move currentj half the time. This way currenti will go through all nodes before catching up
        boolean half = true;
        while (currenti != currentj) {
            if (null == currenti.getNext() || !currenti.getPair().isNextTo(currenti.getNext().getPair()) || !currenti.getNext().getPair().isInBonds(length, width)) {
                return false;
            }
            currenti = currenti.getNext();
            half = !half;
            if (half) {
                currentj = currentj.getNext();
            }
        }
        return true;
    }

    public void prepareBoard() {
        //Collections.sort(pieces);
        for (int index = 0; index < pieces.size(); index++) {
            Piece p = pieces.get(index);
            if (p.getCoords().isInBonds(length, width)) {
                set(p.getCoords().getX(), p.getCoords().getY(), index);
            }
        }
    }


    public String turnHistory() {
        StringBuilder res = new StringBuilder();
        res.append("[ Robots : { ");
        boolean robots = true;
        for (Iterator<Piece> iterator = pieces.iterator(); iterator.hasNext();) {
            Piece p = iterator.next();
            if(p instanceof Intruder i) {
                if(robots){
                    robots = false;
                    res.append("} | Intruders : { ");
                }
                if(i.hasEscaped()){
                    res.append("(Intruder has escaped !) ");
                    iterator.remove();
                }else if(i.gotCaught()) {
                    res.append("(Intruder got caught !) ");
                    iterator.remove();
                }else if(!i.isOnBoard()) {
                    res.append("(Disappeared temporarily) ");
                }else{
                    Pair coords = i.getCoords();
                    res.append("(").append(coords.getX()).append(" . ").append(coords.getY()).append(") ");
                }
            }else{
                Pair coords = p.getCoords();
                res.append("(").append(coords.getX()).append(" . ").append(coords.getY()).append(") ");
            }
        }
        res.append("} ]");
        playTurn();
        return res.toString();
    }


    //Render the state of the game
    public void render() {
        //Alternate graphique printing through terminal
        System.out.print(tostring());
        window.setClearColor(255, 255, 255);//White
        window.clear();
        window.setColor(0, 0, 0);//noir
        //Rendering board
        for (int i = 0; i <= length; i++) {
            window.drawLine(i * tileWidth, 0, i * tileWidth, WINDOW_HEIGHT);
        }
        for (int i = 0; i <= width; i++) {
            window.drawLine(0, i * tileHeight, WINDOW_WIDTH, i * tileHeight);
        }
        //Drawing the robots and intruders
        int r = Math.min(tileWidth, tileHeight) / 2;
        int k = 0;
        for (Piece p : pieces) {
            if (p instanceof Intruder i && !i.gotCaught() && i.isOnBoard() && !i.hasEscaped()) {
                //Drawing a black circle for intruders
                window.setColor(0, 0, 0);
                window.fillCircle((p.getCoords().getX() * tileWidth) + tileWidth / 2, (p.getCoords().getY() * tileHeight) + tileHeight / 2, r);
            }
            if (p instanceof Robot){
                //Drawing a red circle for robots
                window.setColor(255, 0, 0);
                window.fillCircle((p.getCoords().getX() * tileWidth) + tileWidth / 2, (p.getCoords().getY() * tileHeight) + tileHeight / 2, r);
            }
        }
        //Drawing of the newly created shapes
        window.flush();
        //Wait until it's time for the next frame
        FenetreGraphique.wait(waitTime);
    }

    //Prints the game state to terminal
    public String tostring() {
        StringBuilder str = new StringBuilder();
        for (int y = -1; y <= width; y++) {
            for (int x = -1; x <= length; x++) {
                if (x == -1 || y == -1 || x == length || y == width) {
                    str.append(" *");
                    if (x == length) {
                        str.append("\n");
                    }
                } else {
                    if (get(x, y) != -1) {
                        str.append(" ").append(get(x, y));
                    } else {
                        str.append("  ");
                    }
                }
            }
        }
        return str.toString();
    }

}