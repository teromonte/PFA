package pieces;

import entities.CircularArray;

public class Intruder extends Piece {
    private boolean caught;
    private boolean onBoard;
    private boolean escaped;

    public Intruder(CircularArray ca) {
        super(ca);
        caught = false;
        onBoard = true;
        escaped = false;
    }

    public void setCaught(boolean c){
        caught = c;
    }

    public boolean gotCaught(){
        return caught;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean b) {
        onBoard = b;
    }

    public boolean hasEscaped() {
        return escaped;
    }

    public void setEscaped(boolean b) {
        escaped = b;
    }

    public boolean circuitIsValid(int length, int width) {
        return null != this.getCircularArray().getHead() && this.getCircularArray().getHead().getPair().isInBonds(length, width);
    }
}
