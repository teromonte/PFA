package pieces;

import entities.CircularArray;
import entities.Pair;

abstract public class Piece {
    private int index;
    private int id;
    private boolean moved;
    private final CircularArray coords;

    public Piece(int id, CircularArray ca) {
        id = id;
        coords = ca;
        index = 0;
        moved = false;
    }

    public int getIndex() {
        return index;
    }
    public void incrementIndex(){index++;}

    public Pair nextCoords() {
        return coords.iterate(index + 1).getPair();
    }

    public Pair getCoords() {
        return coords.iterate(index).getPair();
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
