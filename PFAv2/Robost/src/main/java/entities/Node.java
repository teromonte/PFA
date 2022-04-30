package entities;
//A node, which contains a pair of coordinates, and points to the next node of the linked list
public class Node {
    private Pair P;
    private Node next;

    public Node(Pair p) {
        P = p;
    }

    public Node GetNext() {
        return next;
    }

    public Pair GetPair() {
        return P;
    }

    public void SetNext(Node n) {
        next = n;
    }
}