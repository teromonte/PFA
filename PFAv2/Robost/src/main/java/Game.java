import entities.CircularArray;
import entities.Node;
import pieces.Intruder;
import pieces.Piece;
import pieces.Robot;

public class Game {
    private final int Length;
    private final int Width;
    public Piece[][] Board;

    public Game(int length, int width) {
        Length = length;
        Width = width;
        Board = new Piece[Length][Width];
        Initialize();
    }

    public void Initialize() {
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Width; j++) {
                Board[i][j] = null;
            }
        }
    }

    public boolean SetPiece(int x, int y, Piece p) {
        Piece curr = Get(x, y);
        if (curr == null) {
            Board[x][y] = p;
            return true;
        } else if (curr instanceof Intruder && p instanceof Robot) {
            p.Die();
            return false;
        }
        return false;
    }

    public Piece Get(int x, int y) {
        return Board[x][y];
    }

    public boolean IsPathValid(CircularArray a) {
        boolean valid = true;
        Node current = a.GetHead();
        if (a.GetHead() == null) {
            valid = false;
        } else {
            do {
                int curX = current.GetPair().GetX();
                int curY = current.GetPair().GetY();
                int nextX = current.GetNext().GetPair().GetX();
                int nextY = current.GetNext().GetPair().GetY();

                //see if is out of board
                if (nextX < 0 || nextX >= Length || nextY < 0 || nextY >= Width) return false;
                //see if is adjacent or diagonal
                if (!(Math.abs(curX - nextX) <= 1 && Math.abs(curY - nextY) <= 1) || !((curX + 1 == nextX) && (curY + 1 == nextY) || (curX + 1 == nextX) && (curY - 1 == nextY) || (curX - 1 == nextX) && (curY + 1 == nextY) || (curX - 1 == nextX) && (curY - 1 == nextY)))
                    return false;

                current = current.GetNext();
            } while (current != a.GetHead());
        }
        return a.isCircular();
    }


}
