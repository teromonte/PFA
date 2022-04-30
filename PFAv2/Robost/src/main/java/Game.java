import entities.CircularArray;
import entities.Node;
import pieces.Intruder;
import pieces.Piece;
import pieces.Robot;

public class Game {
    //The length of the board
    private final int Length;
    //The width of the board
    private final int Width;
    //The board with dimensons length * width. It contains -1 if the space is empty
    //Otherwise it returns the index of the piece in the list of pieces
    public int[][] Board;
    public List<Piece> Pieces = new List<>();

    public Game(int length, int width) {
        Length = length;
        Width = width;
        Board = new Piece[Length][Width];
        Initialize();
    }

    public void Initialize() {
        //We set every spot of the board as beeing empty
        for (int i = 0; i < Length; i++) {
            for (int j = 0; j < Width; j++) {
                Board[i][j] = -1;
            }
        }
    }

    public boolean SetPiece(int x, int y, int p) {
        if (Board[x][y] == -1) {
            Board[x][y] = p;
            return true;
        }
        return false;
    }

    public int Get(int x, int y) {
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
