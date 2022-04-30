package pieces;

import entities.CircularArray;

public class Intruder extends Piece {
    private boolean caught;
    private boolean onBoard;
    public Intruder(CircularArray ca) {
        super(ca);
        caught = false;
        onBoard = true;
    }
}
