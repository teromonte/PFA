package pieces;

import entities.CircularArray;
import entities.Node;
import entities.Pair;

abstract public class Piece implements Comparable<Piece> {
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
        Node n = coords.iterate(index + 1);
        return null == n ? null : n.getPair();
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

    @Override
    public int compareTo(Piece o) {
        if(this instanceof Robot){
            if(o instanceof Robot){
                return 0;
            }
            return -1;
        }
        if(o instanceof Robot){
            return 1;
        }
        return 0;
    }
}
