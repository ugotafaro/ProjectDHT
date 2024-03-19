public class Node {

   //do a class for a node in DHT in discret event simulation
    private int id; //id of the node
    private int data; //data stored in the node
    private int next; //next node in the DHT
    private int prev; //previous node in the DHT


    private int index;


    public Node(int id, int data) {
        this.id = id;
        this.data = data;
        this.index=-1;

    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public int getId() {
        return this.id;
    }

    public int getData() {
        return this.data;
    }

    public int getNext() {
        return this.next;
    }

    public int getPrev() {
        return this.prev;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public void setData(int data) {
        this.data = data;
    }


    public void printNode() {
        System.out.println("Node ID: " + this.id + " Data: " + this.data);
    }




}
