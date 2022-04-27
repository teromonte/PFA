package jetons;

public class JetonsFous{
	public static void main (String args[]){
		
		//caract�ristiques du damier
		int nbCasesHaut;
		int nbCasesLarg;
		int nbJetons;
		boolean rigged=false;
		
		//Demande des param�tres � l'utilisateur
		char answer;
		do{
		System.out.println("Voulez-vous jouer une partie pr�d�finie ?(y/n)");
		answer = Clavier.saisirChar();
		}while(answer != 'y' && answer != 'n');
		if(answer == 'y'){
			rigged = true;
		}
		do{
			System.out.println("Entrez la hauteur du damier (entier, max 1000)");
			nbCasesHaut = Clavier.saisirInt();
		}while(nbCasesHaut <= 0 || nbCasesHaut > 1000);
		do{
			System.out.println("Entrez la largeur du damier (entier, max 1000)");
			nbCasesLarg = Clavier.saisirInt();
		}while(nbCasesLarg <= 0 || nbCasesHaut > 1000);
		do{
			System.out.println("Entrez le nombre de jetons du damier (entier, max = largeur*hauteur)");
			nbJetons = Clavier.saisirInt();
		}while(nbJetons<=0 || nbCasesHaut * nbCasesLarg <= nbJetons);
		
		//Cr�ation du damier selon les param�tres donn�s
		Damier damier = new Damier(nbCasesHaut, nbCasesLarg, nbJetons, rigged);
		//Initialisation de la direction des jetons
		damier.firstDirection();
		//affichage de l'�tat de d�part puis attente de 2s avant le premier d�placement
		damier.render();
		damier.window.wait(2000);
		do{
			//V�rification de la condition de fin de partie
			if(damier.last()){
				//affichage du damier
				damier.render();
				System.out.print("Fin de partie.\n");
				//3s d'attente avant de mettre fin du programme
				damier.window.wait(3000);
				damier.window.exit();
			}else{
				//�volution puis affichage du damier
				damier.evolve();
				damier.render();
			}
		}while(damier.window.notClosed());
		damier.window.exit();
	}
}