package pieces;

import entities.CircularArray;
import entities.Pair;

abstract public class Piece {
    private int index;
    private boolean moved;
    private final CircularArray coords;

    public Piece(CircularArray ca) {
        coords = ca;
        index = 0;
        moved = false;
    }

    public abstract boolean circuitIsValid(int length, int width);

    public Pair nextCoords() {
        return coords.iterate(index + 1).getPair();
    }

    public Pair getCoords() {
        return coords.iterate(index).getPair();
    }

    public CircularArray getCircularArray(){
        return coords;
    }

    public Pair move() {
        index++;
        moved = true;
        return coords.iterate(index).getPair();
    }

    public boolean hasMoved() {
        return moved;
    }

    public void setMoved(boolean b) {
        moved = b;
    }
}
