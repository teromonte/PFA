package jetons;/* Application exemple d'utilisation des methodes    */
/* contenues dans FenetreGraphique.class             */

public class SimpleFenetreGraphique {
  
  public static void main(String [] args) {
  /* Initialisation de la fenetre d'affichage         */
  /* Coin superieur gauche en position �cran (50,50)  */
  /* Fenetre de taille 500x420 pixels                 */
  /* Zone d'affichage de taille 480x360 pixels        */
  /* Titre "Test affichage graphique"                 */
    FenetreGraphique cg = new FenetreGraphique(50,50,500,420,480,360,"Fenetre graphique 1");
  /* Choix d'un vert fonce comme couleur d'effacement */
  /* de la zone d'affichage                           */
    cg.setClearColor(0,40,0);
  /* Ordre d'effacement de la zone d'affichage        */
    cg.clear();
  /* Choix d'un rouge comme couleur de trac�          */
    cg.setColor(200,0,0);
  /* Ordre d'affichage d'un segment de droite         */
  /* Extremite initiale en position (40,70)           */
  /* Extremite finale en position (400,300)           */
    cg.drawLine(40,70,400,300);
  /* Choix d'un bleu comme couleur de trac�           */
    cg.setColor(0,0,200);
  /* Ordre d'affichage d'un cercle                    */
  /* Centre en position (310,170)                     */
  /* Rayon de 90 pixels                               */    
    cg.drawCircle(310,170,90);
  /* Envoi de la zone d'affichage dans la fenetre     */
    cg.flush();
  /* Initialisation de la fenetre d'affichage         */
  /* Coin superieur gauche en position �cran (50,50)  */
  /* Fenetre de taille 500x420 pixels                 */
  /* Zone d'affichage de taille 480x360 pixels        */
  /* Titre "Test affichage graphique"                 */
    FenetreGraphique cg2 = new FenetreGraphique(250,250,500,420,480,360,"Fenetre graphique 2");
  /* Temporisation de 10000 milli-secondes            */
  //  cg.wait(10000);
  /* Fermeture de la fenetre                          */
  //  cg.exit();
  /* Choix d'un jaune clair comme couleur             */
  /* d'effacement de la zone d'affichage              */
    cg2.setClearColor(250,250,200);
  /* Ordre d'effacement de la zone d'affichage        */
    cg2.clear();
  /* Choix du noir comme couleur de trac�             */
    cg2.setColor(0,0,0);
  /* Ordre d'affichage d'un segment de droite         */
  /* Extremite initiale en position (140,70)          */
  /* Extremite finale en position (400,300)           */
    cg2.drawLine(140,70,400,300);
  }   
}