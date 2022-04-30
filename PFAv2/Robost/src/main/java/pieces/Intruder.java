package pieces;

import entities.CircularArray;

public class Intruder extends Piece {
    private boolean caught;
    private boolean onBoard;

    public Intruder(int id, CircularArray ca) {
        super(id, ca);
        caught = false;
        onBoard = true;
    }

    @Override
    public void setCaught(boolean c){
        caught = c;
    }

    @Override
    public boolean gotCaught(){
        return caught;
    }
}
