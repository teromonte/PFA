package entities;

public class CircularArray {
    private Node head, tail;

    public CircularArray() {
        head = null;
        tail = null;
    }

    public void add(Pair p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.SetNext(head);
        } else {
            tail.SetNext(newNode);
            tail = newNode;
            tail.SetNext(head);
        }
    }

    public Node GetHead() {
        return head;
    }

    public Node GetTail() {
        return tail;
    }

    public Pair iterate(int i) {
        Node current = head;
        int j = 0;
        while (j < i) {
            current = current.GetNext();
            j++;
        }
        return current.GetPair();
    }

    public boolean isCircular() {
        if (head == null)
            return true;

        Node node = head.GetNext();

        while (node != null && node != head)
            node = node.GetNext();

        return (node == head);
    }


}