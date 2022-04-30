import entities.Pair;
import pieces.Intruder;
import pieces.Piece;
import pieces.Robot;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //The length of the board
    private final int length;
    //The width of the board
    private final int width;
    //The board with dimensions length * width. It contains -1 if the space is empty
    //Otherwise it returns the index of the piece in the list of pieces
    public int[][] board;
    public List<Piece> pieces = new ArrayList<>();

    public Game(int length, int width) {
        this.length = length;
        this.width = width;
        board = new int[length][width];
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

    //Places the given ID of a piece on the board, at the given coordinates
    public void set(int x, int y, int p) {
        board[x][y] = p;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

    //We iterate over all pieces, checking no two pieces start on the same space
    public boolean differentSpots(){
        for(int i = 0; i < pieces.size(); i++){
            Piece p = pieces.get(i);
            if(!p.getCoords().isInBonds(length, width)){
                continue;
            }
            for(int j = i + 1; j < pieces.size(); j++){
                Piece q = pieces.get(j);
                if(!q.getCoords().isInBonds(length, width)){
                    continue;
                }
                if(p.getCoords().compare(q.getCoords())){
                    return false;
                }
            }
        }
        return true;
    }

    //This function assumes the list of pieces contains first the robots, and then the intruders
    //We expect this function to be called as long as at least 1 piece moves each time
    public boolean movePieces(){
        boolean movedSmth = false;
        for(int index = 0; index < pieces.size(); index++) {
            Piece p = pieces.get(index);
            //We only try to move if the piece has not already moved this turn
            if (p.hasMoved()) {
                continue;
            }
            if (p instanceof Robot robot) {
                movedSmth = movedSmth || moveRobot(robot, index);
            }
            if(p instanceof Intruder intruder) {
                movedSmth = movedSmth || moveIntruder(intruder, index);
            }
        }
        return movedSmth;
    }

    public boolean moveRobot(Robot p, int index){
        boolean movedSmth = false;
        Pair coords = p.getCoords();
        Pair nextCoords = p.nextCoords();
        //If the space we want to move on is empty, the piece moves
        if (get(nextCoords.getX(), nextCoords.getY()) == -1) {
            set(coords.getX(), coords.getY(), -1);
            set(nextCoords.getX(), nextCoords.getY(), index);
            p.move();
            movedSmth = true;
        }else{
            //Else, space is not empty, we check what occupies the space
            Piece otherPiece = pieces.get(get(nextCoords.getX(), nextCoords.getY()));
            //If it is something that already moved this turn
            if(otherPiece.hasMoved()){
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



    public boolean moveIntruder(Intruder p, int index){
        boolean movedSmth = false;
        //We only try to move if the piece has not been caught nor reached the end of its list of coordinates
        if (!p.gotCaught() && !p.hasEscaped()) {
            Pair coords = p.getCoords();
            Pair nextCoords = p.nextCoords();
            if(null == nextCoords){
                p.setOnBoard(false);
                p.setEscaped(true);
                return true;
            }
            //If the next move goes outside the board, the intruder disappears
            if (!nextCoords.isInBonds(length, width)){
                if(p.isOnBoard()){
                    set(coords.getX(), coords.getY(), -1);
                }
                p.setOnBoard(false);
                p.move();
                movedSmth = true;
            //Else, if the next space is empty, we move on
            }else if(get(nextCoords.getX(), nextCoords.getY()) == -1) {
                if(p.isOnBoard()){
                    set(coords.getX(), coords.getY(), -1);
                }
                set(nextCoords.getX(), nextCoords.getY(), index);
                p.setOnBoard(true);
                p.move();
                movedSmth = true;
            //Else we're trying to get to an occupied space
            }else{
                //We check what occupies the space
                Piece otherPiece = pieces.get(get(nextCoords.getX(), nextCoords.getY()));
                //If it is something that already moved this turn
                if(otherPiece.hasMoved()){
                    //And it is a robot, then we get caught
                    if (otherPiece instanceof Robot) {
                        p.setCaught(true);
                        if(p.isOnBoard()){
                            set(coords.getX(), coords.getY(), -1);
                        }
                        p.setOnBoard(true);
                        p.move();
                        movedSmth = true;
                    //Else it is an intruder that has already moved, so we won't be able to move this turn
                    } else {
                        if(p.isOnBoard()){
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

}
