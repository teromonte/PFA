public class Jeton{
	private int x, y, dirX, dirY;
	private boolean alive;
	
	//Constructeur
	Jeton(int x,int y){
		this.x=x;
		this.y=y;
		this.alive=true;
		this.dirX=0;
		this.dirY=0;
	}
	
	//Détruis le jeton
	public void die(){
		this.alive=false;
	}
	
	//Vrai si je jeton est vivant (actif, pas encore détruit)
	public boolean isAlive(){
		return alive;
	}
	
	//set la direction du jeton
	public void setDir(int dirX, int dirY){
		this.dirX=dirX;
		this.dirY=dirY;
	}
	
	//renvoie la coordonnée x du jeton
	public int getX(){
		return this.x;
	}
	
	//renvoie la coordonnée y du jeton
	public int getY(){
		return this.y;
	}
	
	//renvoie la direction en x du jeton
	public int getDirX(){
		return this.dirX;
	}
	
	//renvoie la direction en y du jeton
	public int getDirY(){
		return this.dirY;
	}
	
	//renvoie la position en x du jeton après le prochain mouvement
	public int getNextX(){
		return this.x+this.dirX;
	}
	
	//renvoie la position en y du jeton après le prochain mouvement
	public int getNextY(){
		return this.y+this.dirY;
	}
	
	//déplace le jeton d'une case selon sa direction
	public void move(){
		this.x+=this.dirX;
		this.y+=this.dirY;
	}
	
	//Vérifie si les deux jetons sont vivants et si leur coordonnées (x,y) sont les même
	public boolean isEqual(Jeton j){
		return this.x==j.x && this.y==j.y && this.isAlive() && j.isAlive();
	}
}