public class Node {

    private int id;
    private Node next;
    private Node prev;

    public Node(int id) {
        this.id = id;
        this.next = null;
        this.prev = null;
    }

    public int getId() {
        return id;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }
}
