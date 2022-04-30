package pieces;

import entities.CircularArray;
import entities.Pair;

abstract public class Piece {
    private int index;
    private int id;
    private boolean moved;
    private CircularArray coords;

    public Piece(int id, CircularArray ca) {
        id = id;
        coords = ca;
        index = 0;
        moved = false;
    }

    public int getIndex() {
        return index;
    }
    public void incerementIndex(){index++;}

    public Pair nextCoords() {
        return coords.iterate(index + 1).GetPair();
    }

    public Pair move() {
        index++;
        moved = true;
        return coords.iterate(index).GetPair();
    }

    public boolean hasMoved() {
        return moved;
    }

    public void setMoved(boolean b) {
        moved = b;
    }

}
