public class JetonsFous{
	public static void main (String args[]){
		
		//caractéristiques du damier
		int nbCasesHaut;
		int nbCasesLarg;
		int nbJetons;
		boolean rigged=false;
		
		//Demande des paramètres à l'utilisateur
		char answer;
		do{
		System.out.println("Voulez-vous jouer une partie prédéfinie ?(y/n)");
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
		
		//Création du damier selon les paramètres donnés
		Damier damier = new Damier(nbCasesHaut, nbCasesLarg, nbJetons, rigged);
		//Initialisation de la direction des jetons
		damier.firstDirection();
		//affichage de l'état de départ puis attente de 2s avant le premier déplacement
		damier.render();
		damier.window.wait(2000);
		do{
			//Vérification de la condition de fin de partie
			if(damier.last()){
				//affichage du damier
				damier.render();
				System.out.print("Fin de partie.\n");
				//3s d'attente avant de mettre fin du programme
				damier.window.wait(3000);
				damier.window.exit();
			}else{
				//évolution puis affichage du damier
				damier.evolve();
				damier.render();
			}
		}while(damier.window.notClosed());
		damier.window.exit();
	}
}