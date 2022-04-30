package entities;
//A pair of coordinates
public class Pair {
    private int X, Y;

    public Pair(int x, int y) {
        X = x;
        Y = y;
    }

    public int GetX(){
        return this.X;
    }

    public int GetY(){
        return this.Y;
    }
}
