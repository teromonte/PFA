import entities.CircularArray;
import entities.Node;
import entities.Pair;
import pieces.Intruder;
import pieces.Robot;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Board characteristics
        int length = 25;
        int width = 10;
        //Pour activer ou non l'affichage graphique
        boolean GUI = true;

        //Board creation
        Game game = new Game(length, width, GUI);
        //Robot 1
        CircularArray coords = new CircularArray();
        coords.add(2, 5);//We loop back here
        coords.add(3, 6);
        coords.add(4, 5);
        coords.add(3, 4);
        coords.add(coords.iterate(0));
        game.addPiece(new Robot(coords));
        //Robot 2
        CircularArray coords2 = new CircularArray();
        coords2.add(4, 5);
        coords2.add(3, 6);//We loop back here
        coords2.add(4, 5);
        coords2.add(3, 4);
        coords2.add(2, 3);
        coords2.add(2, 4);
        coords2.add(2, 5);
        coords2.add(coords2.iterate(1));
        game.addPiece(new Robot(coords2));
        //Intruder 1
        CircularArray coords3 = new CircularArray();
        coords3.add(7, 9);
        coords3.add(3, 8);
        coords3.add(2, 1);
        coords3.add(-1, 1);
        coords3.add(-1, 8);
        coords3.add(4, 5);//We loop back here
        coords3.add(3, 4);
        //coords3.add(coords3.iterate(5));
        game.addPiece(new Intruder(coords3));

        CircularArray coords4 = new CircularArray();
        coords4.add(4, 9);
        coords4.add(3, 8);
        coords4.add(8, 6);
        coords4.add(-1, 1);
        coords4.add(4, 5);
        coords4.add(3, 8);//We loop back here
        coords4.add(3, 4);
        coords4.add(coords4.iterate(5));
        game.addPiece(new Intruder(coords4));

        ArrayList<CircularArray> deplRobots = new ArrayList<>();
        deplRobots.add(coords);
        deplRobots.add(coords2);
        ArrayList<CircularArray> deplIntrus = new ArrayList<>();
        deplIntrus.add(coords3);
        deplIntrus.add(coords4);

        System.out.println("History :");
        history(length , width , deplRobots , deplIntrus, 10).forEach(System.out::println);
        System.out.println("End of history");


        //First print of the board
        game.prepareBoard();
        if(GUI) {
            if (!game.differentSpots()) {
                System.out.println("2 pieces start on the same spot");
                FenetreGraphique.exit();
                return;
            }
            if(!game.validPieces()){
                System.out.println("one or more pieces have invalid lists of coordinates");
                FenetreGraphique.exit();
                return;
            }
            game.render();
            //2s wait
            FenetreGraphique.wait(2000);
            int maxTurns = 15;
            do {
                //We move the pieces
                game.playTurn();
                game.render();
                maxTurns--;
                System.out.println("Turn left : " + maxTurns);
            } while (maxTurns > 0 && game.window.notClosed());
            FenetreGraphique.exit();
        }
    }

    //history function. Returns a stream of strings depicting the evolution of the board. nbrTours sets the number of turns to compute. Set it to 0 or negative to create an infinite stream
    public static Stream<String> history(int length , int width , ArrayList<CircularArray> deplR, ArrayList<CircularArray> deplI, int nbTurns) {
        boolean limit = nbTurns > 0;
        Game game = new Game(length, width, false);
        for(CircularArray ca : deplR) {
            game.addPiece(new Robot(ca));
        }
        for(CircularArray ca : deplI) {
            game.addPiece(new Intruder(ca));
        }
        game.prepareBoard();
        if (!game.differentSpots()) {
            return Stream.of("Two pieces start on the same spot");
        }
        if(!game.validPieces()){
            return Stream.of("One or more pieces have invalid lists of coordinates");
        }
        if(limit){
            return Stream.generate(game::turnHistory).limit(nbTurns);
        }
        return Stream.generate(game::turnHistory);
    }
}
