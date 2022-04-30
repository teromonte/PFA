package entities;
//A pair of coordinates
public class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    //True if the given pair contains different coordinates, and the given pair is next to this. False otherwise
    public boolean isNextTo(Pair p){
        return !(x == p.getX() && y == p.getY()) && (Math.abs(x - p.getX()) <= 1 && Math.abs(y - p.getY()) <= 1);
    }

    //True if the pair is inside the given length and width
    public boolean isInBonds(int length, int width){
        return 0 <= x && x < length && 0 <= y && y < width;
    }
}
