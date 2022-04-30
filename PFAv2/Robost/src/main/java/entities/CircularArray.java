package entities;

public class CircularArray {
    private Node head, tail;
    //Head is the first node of the list
    //Tail is the last one (we keep it for better optimization when adding new nodes)
    public CircularArray() {
        head = null;
        tail = null;
    }
    //When trying to add a node at the end of the list,
    // we check if the list is empty (then we add the node as head),
    // or if the circular list is already closed (in which case we do nothing)
    public boolean add(Node n){
        if(null == head){
            head = n;
            tail = n;
            return true;
        }
        if(tail.getNext() != null){
            return false;
        }
        tail.setNext(n);
        tail = n;
        return true;
    }

    public boolean add(int x, int y){
        if(null == head){
            head = new Node(new Pair(x, y));
            tail = head;
            return true;
        }
        if(tail.getNext() != null){
            return false;
        }
        tail.setNext(new Node(new Pair(x, y)));
        tail = tail.getNext();
        return true;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    //returns the ith node
    public Node iterate(int i) {
        Node current = head;
        while (i > 0) {
            current = current.getNext();
            i--;
        }
        return current;
    }

    //Returns false if the circular list is either : empty, contains 1 element,
    // contains 1 element that loops back to itself, reaches a next element which is null
    //Returns true if currenti does a full loop and catches up with currentj
    public boolean isCircular() {
        if (null == head || null == head.getNext() || head.getNext() == head){
            return false;
        }
        Node currenti = head.getNext();
        Node currentj = head;
        while (currenti != currentj){
            if(null == currenti.getNext() && null == currenti.getNext().getNext()){
                return false;
            }
            currenti = currenti.getNext().getNext();
            currentj = currentj.getNext();
        }
        return true;
    }
}