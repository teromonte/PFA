package entities;

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