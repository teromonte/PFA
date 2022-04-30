package pieces;

import entities.CircularArray;

public class Robot extends Piece {

    public Robot(CircularArray ca) {

        super(ca);
    }

    public boolean circuitForRobot(int length, int width, CircularArray ca) {
        if (null == ca.getHead() || null == head.getNext() || head.getNext() == head){
            return false;
        }
        Node currenti = head.getNext();
        Node currentj = head;
        if(!currentj.getPair().isNextTo(currenti.getPair()) || !currentj.getPair().isInBonds(length, width) || !currenti.getPair().isInBonds(length, width)){
            return false;
        }
        //So that we only move currentj half the time. This way currenti will go through all nodes before catching up
        boolean half = true;
        while (currenti != currentj){
            if(null == currenti.getNext() || !currenti.getPair().isNextTo(currenti.getNext().getPair()) || !currenti.getNext.getPair().isInBonds(length, width)){
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
