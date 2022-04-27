public class Robot extends Jeton {
    private int x, y;

    Robot(int x, int y, CircularArray coord;) {
        super(x, y, coord);
        //TODO Auto-generated constructor stub
    }
	
	//d�place le jeton d'une case selon sa direction
	public void move(){
		this.x+=this.dirX;
		this.y+=this.dirY;
	}
}
