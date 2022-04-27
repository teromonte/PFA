public class Intruder extends Jeton{

    Intruder(int x, int y) {
        super(x, y);
        //TODO Auto-generated constructor stub
    }
    
    //renvoie la position en x du jeton apr�s le prochain mouvement
	public int getNextX(){
		return this.x+this.dirX;
	}
	
	//renvoie la position en y du jeton apr�s le prochain mouvement
	public int getNextY(){
		return this.y+this.dirY;
	}
	
	//d�place le jeton d'une case selon sa direction
	public void move(){
		this.x+=this.dirX;
		this.y+=this.dirY;
	}
}
