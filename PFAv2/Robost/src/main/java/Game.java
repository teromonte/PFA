import entities.CircularArray;
import entities.Node;
import pieces.Intruder;
import pieces.Piece;
import pieces.Robot;

public class Game {
    //The length of the board
    private final int length;
    //The width of the board
    private final int width;
    //The board with dimensons length * width. It contains -1 if the space is empty
    //Otherwise it returns the index of the piece in the list of pieces
    public int[][] board;
    public List<Piece> pieces = new List<>();

    public Game(int length, int width) {
        length = length;
        width = width;
        board = new int[length][width];
        initialize();
    }

    public void initialize() {
        //We set every spot of the board as beeing empty
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = -1;
            }
        }
    }

    public boolean setPiece(int x, int y, int p) {
        if (board[x][y] == -1) {
            board[x][y] = p;
            return true;
        }
        return false;
    }

    public int get(int x, int y) {
        return board[x][y];
    }

}
