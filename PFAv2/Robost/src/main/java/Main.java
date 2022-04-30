import entities.CircularArray;
import entities.Node;
import entities.Pair;
import pieces.Intruder;
import pieces.Robot;

public class Main {
    public static void main(String[] args) {
        //Board characteristics
        int length = 50;
        int width = 40;

        //Board creation
        Game game = new Game(length, width);
        //Robot 1
        CircularArray coords = new CircularArray();
        coords.add(2, 5);//We loop back here
        coords.add(3, 6);
        coords.add(4, 5);
        coords.add(3, 4);
        coords.add( coords.iterate(0));
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
        coords2.add(coords.iterate(1));
        coords2.add( coords.iterate(0));
        game.addPiece(new Robot(coords2));
        //Intruder 1
        CircularArray coords3 = new CircularArray();
        coords3.add(20, 15);
        coords3.add(-20, 15);
        coords3.add(2, 1);
        coords3.add(3, 4);
        game.addPiece(new Intruder(coords3));

        //First print of the board
        //game.render();
        //2s wait
        //game.window.wait(2000);
        if(!game.differentSpots() || !game.validPieces()){
            System.out.println("Either pieces have invalid lists of coordinates, or 2 pieces start on the same spot");
            return;
        }
        int maxTurns = 10;
        do{
            //We move the pieces
            game.movePieces();
            //game.render();
            maxTurns--;
        }while(maxTurns > 0);//game.window.notClosed());
        //game.window.exit();
    }
}
