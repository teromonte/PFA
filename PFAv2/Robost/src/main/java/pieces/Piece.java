package pieces;

import entities.CircularArray;
import entities.Pair;

abstract public class Piece {
    private int X, Y;
    private int i;
    private boolean Alive, HasMoved;
    private CircularArray A;

    public Piece(boolean alive, int x, int y, CircularArray a) {
        Alive = alive;
        HasMoved = false;
        i = 0;
        X = x;
        Y = y;
        A = a;
    }

    public int GetIndex() {
        return i;
    }

    public Pair TryToMove() {
        return A.iterate(i + 1);
    }

    public Pair Move() {
        i++;
        HasMoved = true;
        return A.iterate(i);
    }

    public boolean HasMoved() {
        return HasMoved;
    }

    public void ResetHasMoved() {
        HasMoved = false;
    }

    public void Die() {
        Alive = false;
    }

    public boolean IsAlive() {
        return Alive;
    }

    public int GetX() {
        return X;
    }

    public int GetY() {
        return Y;
    }
}
