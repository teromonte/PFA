package jetons;/* Application exemple d'utilisation des methodes   */
/* contenues dans EcranGraphique.class              */

public class TestFenetreGraphique {
  
  public static void croix(FenetreGraphique cg,int x,int y) {
    cg.drawLine(x-10,y,x+10,y);
    cg.drawLine(x,y-10,x,y+10);
  }
  
  public static void main(String [] args) {
    int val = -1;
  /* Initialisation de la fenetre d'affichage       */
    FenetreGraphique cg = new FenetreGraphique(50,50,480,360,640,480,"Test affichage graphique");
  /* Boucle de gestion de l'application             */
    while ( val != 0 ) {
  /* Menu                                           */
      Ecran.afficherln(" 1 - Afficher 3 pixels");      
      Ecran.afficherln(" 2 - Afficher un segment de droite");      
      Ecran.afficherln(" 3 - Animer un segment de droite");
      Ecran.afficherln(" 4 - Afficher un rectangle et remplir un rectangle");
      Ecran.afficherln("     Afficher un cercle et remplir un cercle");
      Ecran.afficherln(" 5 - Afficher une chaine de caracteres");      
      Ecran.afficherln(" 6 - Tester l'alpha-blending");
      Ecran.afficherln(" 7 - Effacer l'ecran");
      Ecran.afficherln(" 8 - Lire un caractere au clavier");
      Ecran.afficherln(" 9 - Deplacer une croix a la souris");
      Ecran.afficherln("10 - Lire une image PNG et l'afficher");
      Ecran.afficherln("11 - Lire une image PNG sur le web et l'afficher");
      Ecran.afficherln("12 - Tester getMouseState()");
      Ecran.afficherln("13 - Tester getMouseButton()");
      Ecran.afficherln(" 0 - Quitter");
      Ecran.afficher("Choix ? ");
      val = Clavier.saisirInt();
  /* Action en fonction de la valeur saisie         */
      switch (val) {
        case 1 : {
  /* Affichage de trois pixels de couleurs differentes */
          cg.setColor(200,0,0);
          cg.drawPixel(100,200);
          cg.setColor(0,200,0);
          cg.drawPixel(200,100);
          cg.setColor(0,0,200);
          cg.drawPixel(300,200);
          cg.flush(); }
          break;
        case 2 : {
  /* Affichage d'un segment de droite               */
          cg.setColor(200,0,0);
          cg.drawLine(-100,100,100,100);
          cg.flush(); }
          break;
        case 3 : {
  /* Animation d'un segment de droite               */
          long ti = System.nanoTime();
          for ( int i = 0 ; i <= 768 ; i++ ) {
            cg.clear();
            cg.setColor(i/3,i%256,(i+128)%256);
            cg.drawLine((int) (320+200*Math.cos(i*Math.PI*2.0/768.0)+0.5),
                                    (int) (240+200*Math.sin(i*Math.PI*2.0/768.0)+0.5),
                                    (int) (320-200*Math.cos(i*Math.PI*2.0/768.0)+0.5),
                                    (int) (240-200*Math.sin(i*Math.PI*2.0/768.0)+0.5));
            cg.flush(); }
          long tf = System.nanoTime();
          System.out.println((tf-ti)/1000000); }
          break;
        case 4 : {
  /* Affichage d'un rectangle                       */
          cg.setColor(200,0,0);
          cg.drawRect(-100,100,370,500);
  /* Affichage d'un cercle                          */
          cg.setColor(0,200,0);
          cg.drawCircle(120,250,200);
  /* Remplissage d'un cercle                        */
          cg.setColor(0,200,200);
          cg.fillCircle(500,320,240);
  /* Remplissage d'un rectangle                     */
          cg.setColor(200,200,0);
          cg.fillRect(500,300,700,100);
          cg.flush(); }
          break;
        case 5 : {
  /* Affichage d'une chaine de caracteres */
          cg.setColor(255,255,255);
          cg.drawString(10,200,FenetreGraphique.SYMBOL8x13,"ABCDEFGHIJKLMNOPQRSTUVWXYZ-abcdefghijklmnopqrstuvwxyz-0123456789");
          cg.drawString(10,220,FenetreGraphique.COLABA8x13,"ABCDEFGHIJKLMNOPQRSTUVWXYZ-abcdefghijklmnopqrstuvwxyz-0123456789");
          cg.flush(); }
          break;
        case 6 : {
  /* Affichage d'un rectangle                       */
          cg.setColor(200,0,0);
          cg.drawRect(-100,100,400,500);
  /* Remplissage d'un rectangle                     */
          cg.setColor(200,200,0);
          cg.fillRect(500,300,700,100);
          cg.setAlphaBlendingMode(true);
          cg.setAlpha(0.5);
  /* Affichage d'un cercle                          */
          cg.setColor(0,200,0);
          cg.drawCircle(120,250,200);
  /* Remplissage d'un cercle                        */
          cg.setColor(0,200,200);
          cg.fillCircle(500,320,240);
          cg.setAlphaBlendingMode(false);
          cg.flush(); }
          break;
        case 7 : {
  /* Effacement de la fenetre de dessin             */
          cg.clear();
          cg.flush(); }
          break;
        case 8 : {
  /* Lecture d'un caractere au clavier              */
          char c;
          while ( (c = cg.getKey()) == 0x00 );
          System.out.println(c);
          System.out.println((int) c); }
          break;
        case 9 : {
  /* Deplacement d'une croix a la souris            */
          cg.setColor(255,255,255);
          while ( cg.getMouseState() == 0 ) {
            FenetreGraphique.wait(10); }
          cg.setXorMode(true);
          int xOld = cg.getMouseX();
          int yOld = cg.getMouseY();
          croix(cg,xOld,yOld);
          while ( cg.getMouseState() == 1 ) {
            int x = cg.getMouseX();
            int y = cg.getMouseY();
            if ( ( x != xOld ) || ( y != yOld ) ) {
              croix(cg,xOld,yOld);
              xOld = x;
              yOld = y;
              croix(cg,x,y);
              cg.flush(); }
              else {
              FenetreGraphique.wait(10); } }
          croix(cg,xOld,yOld);
          cg.flush();
          cg.setXorMode(false); }
          break;
        case 10 : {
  /* Lecture et affichage d'une image PNG           */
          Ecran.afficher("Quel fichier? ");
          String file = Clavier.saisirString();
          int [][] img = cg.loadPNGFile(file);
          if ( img != null ) {
            cg.drawImage(0,0,img);
            cg.flush(); } }
          break;
        case 11 : {
  /* Lecture et affichage d'une image PNG           */
          Ecran.afficher("Quelle url? ");
          String url = Clavier.saisirString();
          int [][] img = cg.downloadPNGFile(url);
          if ( img != null ) {
            cg.drawImage(0,0,img);
            cg.flush(); } }
          break;
        case 12 : {
          boolean go = true;
          while (go) {
            FenetreGraphique.wait(10);
            int v = cg.getMouseState();
            if ( v == 2 ) {
              go = false; }
            Ecran.afficherln(v); }
          Ecran.afficherln("Par le bouton ",cg.getMouseButton()); }
          break;
        case 13 : {
          boolean go = true;
          while (go) {
            FenetreGraphique.wait(10);
            int v = cg.getMouseButton();
            if ( v == 2 ) {
              go = false; }
            Ecran.afficherln(v); } }
          break;
        case 14 : {
          cg.setWindowResizable(false);
          cg.setWindowSize(800,600); }
          break;
        case 0 : {
          Ecran.afficherln("A bientot!!!");
          break; } } }
  /* Fermeture de la fenetre                        */
  /* et interruption de l'application               */
    FenetreGraphique.exit();
  }   
}