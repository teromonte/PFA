package entities;
//A node, which contains a pair of coordinates, and points to the next node of the linked list
public class Node {
    private final Pair p;
    private Node next;

    public Node(Pair p) {
        this.p = p;
    }

    public Node getNext() {
        return next;
    }

    public Pair getPair() {
        return p;
    }

    public void setNext(Node n) {
        next = n;
    }
}