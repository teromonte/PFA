import entities.CircularArray;
import entities.Node;
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
    public List<Piece> pieces = new ArrayList<Piece>();

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

    //This function assumes the list of pieces contains first the robots, and then the intruders
    //We expect this function to be called as long as at least 1 piece moves each time
    public boolean movePieces(){
        boolean movedSmth = false;
        for(int index = 0; index < pieces.size(); index++){
            Piece p = pieces.get(index);

            //We only try to move if the piece has not already moved this turn (nor has been caught)
            if (!p.hasMoved() && !(p instanceof Intruder && p.gotCaught())) {
                Pair coords = p.getCoords();
                Pair nextCoords = p.nextCoords();
                //If the space is empty, the piece moves
                if (get(nextCoords.getX(), nextCoords.getY()) == -1) {
                    set(coords.getX(), coords.getY(), -1);
                    set(nextCoords.getX(), nextCoords.getY(), index);
                    p.move();
                    p.setMoved(true);
                    movedSmth = true;
                }else{
                    //Else, space is not empty, we check what occupies the space
                    Piece otherPiece = pieces.get(get(nextCoords.getX(), nextCoords.getY()));
                    //If it is something that already moved this turn
                    if(otherPiece.hasMoved()){
                        //And we are a robot
                        if(p instanceof Robot) {
                            //And it is a robot, then we will not be able to move this turn
                            if (otherPiece instanceof Robot) {
                                p.setMoved(true);
                                //Else it is an intruder that has already moved, hence we capture it
                            } else {
                                otherPiece.setCaught(true);
                                set(coords.getX(), coords.getY(), -1);
                                set(nextCoords.getX(), nextCoords.getY(), index);
                                p.move();
                                p.setMoved(true);
                                movedSmth = true;
                            }
                        //Else we are an intruder
                        }else{
                            //And it is a robot that has already moved, hence we get caught
                            if (otherPiece instanceof Robot) {
                                p.setCaught(true);
                                set(coords.getX(), coords.getY(), -1);
                                p.move();
                                p.setMoved(true);
                                movedSmth = true;
                                //Else it is an intruder, then we will never be able to move this turn
                            } else {
                                p.setMoved(true);
                            }
                        }
                    //Else the space is occupied by something which hasn't moved yet, hence we wait
                    }
                }
            }
        }
        return movedSmth;
    }

}
