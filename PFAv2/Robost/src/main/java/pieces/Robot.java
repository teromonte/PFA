package pieces;

import entities.CircularArray;
import entities.Node;

public class Robot extends Piece {

    public Robot(int id, CircularArray ca) {

        super(id, ca);
    }

    public boolean circuitForRobot(int length, int width, CircularArray ca) {
        if (null == ca.getHead() || null == ca.getHead().getNext() || ca.getHead().getNext() == ca.getHead()){
            return false;
        }
        Node currenti = ca.getHead().getNext();
        Node currentj = ca.getHead();
        if(!currentj.getPair().isNextTo(currenti.getPair()) || !currentj.getPair().isInBonds(length, width) || !currenti.getPair().isInBonds(length, width)){
            return false;
        }
        //So that we only move currentj half the time. This way currenti will go through all nodes before catching up
        boolean half = true;
        while (currenti != currentj){
            if(null == currenti.getNext() || !currenti.getPair().isNextTo(currenti.getNext().getPair()) || !currenti.getNext().getPair().isInBonds(length, width)){
                return false;
            }
            currenti = currenti.getNext();
            half = !half;
            if(half){
                currentj = currentj.getNext();
            }
        }
        return true;
    }
}
