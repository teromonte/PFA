import java.util.Random; 

public class Damier{
	//damier
	private int nbCasesHaut;
	private int nbCasesLarg;
	private int nbJetons;
	private boolean rigged;
	private Jeton[] tab;
	private int[][] couleur;
	
	private Random rand=new Random(42);
	
	//Fenêtre graphique
	private final String GAME_NAME = "Jetons Fous";
	private final double FPS = 10.0;
	//dimensions de la fenêtre
	private final int SCREEN_HEIGHT = 800;
	private final int SCREEN_WIDTH = 800;
	//dimensions de la zone d'affichage dans la fenêtre
	private final int WINDOW_HEIGHT = 700;
	private final int WINDOW_WIDTH = 700;
	
	public FenetreGraphique window = new FenetreGraphique(0,0,SCREEN_WIDTH,SCREEN_HEIGHT,WINDOW_WIDTH,WINDOW_HEIGHT,GAME_NAME);
	
	private int tileHeight;
	private int tileWidth;
	
	//Fonction pour générer des nombres aléatoires ou non, en fonction de rigged
	private double rand(){
		if(rigged){
			return rand.nextDouble();
		}
		return Math.random();
	}
	
	//Constructeur
	public Damier(int nbCasesHaut, int nbCasesLarg, int nbJetons, boolean rigged){
		this.rigged=rigged;
		this.nbCasesHaut = nbCasesHaut;
		this.nbCasesLarg = nbCasesLarg;
		this.nbJetons = nbJetons;
		this.tileHeight = (WINDOW_HEIGHT-1)/nbCasesHaut;
		this.tileWidth = (WINDOW_WIDTH-1)/nbCasesLarg;
		//Le -1 permet d'afficher la délimitation du damier à droite et en bas, sinon le tracé sort de la zone d'affichage
		tab = new Jeton[nbJetons];
		//On initialise le contenu du tableau avant de le remplir avec des jetons valides
		for(int i = 0; i <= tab.length-1; i++){
			this.tab[i] = new Jeton(-1,-1);
		}
		for(int i = 0; i <= tab.length-1; i++){
		Jeton j = new Jeton((int)(rand()*nbCasesLarg),(int)(rand()*nbCasesHaut));
			while(this.isInside(j)){
				j = new Jeton((int)(rand()*nbCasesLarg),(int)(rand()*nbCasesHaut));
			}
		tab[i]=j;
		}
		//On initialise le tableau de couleurs des jetons
		couleur = new int[nbJetons][3];
		for(int i=0; i <= tab.length-1; i++){
			for(int j = 0; j <= couleur[i].length-1; j++){
				couleur[i][j]=(int)(rand()*256);
			}
		}
	}
	
	//affiche le damier dans la console et dans une fenêtre graphique
	public void render(){
		/*affichage dans la console via tostring(), n'est plus nécéssaire puisqu'on se sert de l'API graphique*/
		System.out.print(this.tostring()); 
		window.setClearColor(255,255,255);//blanc
		window.clear();
		window.setColor(0,0,0);//noir
		//affichage du damier
		for(int i = 0; i <= nbCasesLarg; i++){
			window.drawLine(i*tileWidth, 0, i*tileWidth, WINDOW_HEIGHT);
		}
		for(int i = 0; i <= nbCasesHaut; i++){
			window.drawLine(0, i*tileHeight, WINDOW_WIDTH, i*tileHeight);
		}
		
		//Dessin des jetons
		/*à utiliser pour dessiner les cercles
		*/
		int r = Math.min(tileWidth,tileHeight)/2;
		
		/*à utiliser pour dessiner les formes incongrues
		
		int r = Math.min(tileWidth,tileHeight)/5;
		*/
		for(int i = 0; i <= nbJetons-1; i++){
			if(this.tab[i].isAlive()){
				window.setColor(couleur[i][0],couleur[i][1],couleur[i][2]);
				/*Dessin d'un jeton circulaire
				*/
				window.fillCircle((this.tab[i].getX() * tileWidth) + tileWidth/2, (this.tab[i].getY() * tileHeight) + tileHeight/2, r);
				
				/*Dessin de la direction (optionnel)
				
				window.drawLine((this.tab[i].getX() * tileWidth) + tileWidth/2, (this.tab[i].getY() * tileHeight) + tileHeight/2,(this.tab[i].getNextX() * tileWidth) + tileWidth/2, (this.tab[i].getNextY() * tileHeight) + tileHeight/2);
				*/
				/*Dessin d'une forme incongrue
				
				window.fillCircle((this.tab[i].getX() * tileWidth) + tileWidth/2 - r*3/4, (this.tab[i].getY() * tileHeight) + tileHeight/2 + tileHeight/4, r);
				window.fillCircle((this.tab[i].getX() * tileWidth) + tileWidth/2 + r*3/4, (this.tab[i].getY() * tileHeight) + tileHeight/2 + tileHeight/4, r);
				window.fillRect((this.tab[i].getX() * tileWidth) + tileWidth/2 - r/2, (this.tab[i].getY() * tileHeight) + r/2, r, tileHeight/2 + tileHeight/4 - r/2);
				window.fillCircle((this.tab[i].getX() * tileWidth) + tileWidth/2, (this.tab[i].getY() * tileHeight) + r/2, r/2);
				*/
			}
		}
		//affichage à l'écran des objets définis précédement
		window.flush();
		//attente d'atteindre environ le nombre d'images par secondes indiqué par FPS
		window.wait((int)(1000/FPS));
	}
	
	//Donne une direction aléatoire à tous les jetons du damier
	public void firstDirection(){
		for(int i = 0; i <= this.tab.length-1; i++){
			do{
				this.tab[i].setDir(((int)(rand()*3)-1),((int)(rand()*3)-1));
			}while(this.tab[i].getDirX() == 0 && this.tab[i].getDirY() == 0);
		}
	}
	
	//Vrai si le jeton en paramètre va sortir du damier au prochain déplacement
	public boolean willMoveOut(Jeton j){
		return j.getNextX() < 0 || j.getNextX() > nbCasesLarg-1 || j.getNextY() < 0 || j.getNextY() > nbCasesHaut-1;
	}
	
	//Vrai si les jetons en paramètre vont entrer en collision au prochain déplacement
	public boolean willCollide(Jeton j, Jeton k){
		if(k.isAlive() && j.isAlive()){
			boolean case1 = k.getNextX() == j.getX() && j.getNextX() == k.getX() && k.getNextY() == j.getY() && j.getNextY() == k.getY();
			boolean case2 = k.getNextX() == j.getNextX() && k.getNextY() == j.getNextY();
			boolean case3 = k.getX() + k.getDirX()/2 == j.getX() + j.getDirX()/2 && k.getY() + k.getDirX()/2 == j.getY() + j.getDirY()/2;
			return case1 || case2 || case3;
		}
		return false;
	}
	
	//Vrai si le jeton en paramètre a les même coordonnées qu'un jeton du damier
	public boolean isInside(Jeton j){
		for(int i = 0; i <= this.tab.length-1; i++){
			if(this.tab[i].isEqual(j)){
				return true;
		 	}	
		}
		return false;
	}
	
	//Détruit les jetons du damier nécessaires afin qu'il n'y ait pas de collisions au prochain déplacement
	public void collide(){
		for(int i = 0; i <= this.tab.length-1; i++){
			for(int j = 0; j <= this.tab.length-1; j++){
				if(i != j){
					if(this.willCollide(this.tab[i], this.tab[j])){
						this.tab[j].die();
					}
				}
			}
		}
	}
	
	//Assigne une nouvelle direction valide aux jetons du damier qui devraient sortir du damier au prochain déplacement
	public void out(){
		for(int i = 0; i <= this.tab.length-1; i++){
			if(this.willMoveOut(this.tab[i]) && this.tab[i].isAlive()){
				do{
					this.tab[i].setDir(((int)(rand()*3)-1),((int)(rand()*3)-1));
				}while(this.willMoveOut(this.tab[i]) || (this.tab[i].getDirX() == 0 && this.tab[i].getDirY() == 0));
			}
		}
	}
	
	//Vrai s'il ne reste plus qu'un jeton dans le damier
	public boolean last(){
		int compteur = 0;
		for(int i = 0; i <= this.tab.length-1; i++){
			if(this.tab[i].isAlive()){
				compteur++;
			}
		}
		if(compteur <= 1){
			return true;
		}
		return false;
	}
	
	//Déplace les jetons du damier
	public void move(){
		for(int i = 0; i<= this.tab.length-1; i++){
			if(this.tab[i].isAlive()){
				this.tab[i].move();
			}
		}
	}
	
	//Renvoie le damier sous forme d'une chaine de caractères
	public String tostring(){
		String str= "";
		for(int y = -1; y <= nbCasesHaut; y++){
			for(int x = -1; x <= nbCasesLarg; x++){
				if(x == -1 || y == -1 || x == nbCasesLarg || y == nbCasesHaut){
					str += " *";
					if(x == nbCasesLarg){
						str += "\n";	
					}					
				}else{
					Jeton k = new Jeton(x,y);
					if(this.isInside(k)){
						str += " @";
					}else{
						str += "  ";
					}
				}
			}
		}
		return str;
	}
	
	//Change la direction des jetons pour ne pas qu'il sortent du damier, puis suprimme les jetons requis pour éviter les collisions, puis déplace les jetons
	public void evolve(){
		this.out();
		this.collide();
		this.move();
	}
	
}