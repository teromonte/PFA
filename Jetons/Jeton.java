abstract class Jeton {

	private int x, y;
	private boolean alive;
	private CircularArray coord;

	//Constructeur
	Jeton(int x,int y, CircularArray coord){
		this.x=x;
		this.y=y;
		this.alive=true;
		this.coord = coord;
	}
	
	//D�truis le jeton
	public void die(){
		this.alive=false;
	}
	
	//Vrai si je jeton est vivant (actif, pas encore d�truit)
	public boolean isAlive(){
		return alive;
	}
	
	//set la direction du jeton
	public void setDir(int dirX, int dirY){
		this.dirX=dirX;
		this.dirY=dirY;
	}
	
	//renvoie la coordonn�e x du jeton
	public int getX(){
		return this.x;
	}
	
	//renvoie la coordonn�e y du jeton
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
	
	//V�rifie si les deux jetons sont vivants et si leur coordonn�es (x,y) sont les m�me
	public boolean isEqual(Jeton j){
		return this.x==j.x && this.y==j.y && this.isAlive() && j.isAlive();
	}
}