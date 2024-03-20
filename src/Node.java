public class Node {

    private int id; //id of the node
    private int data; //data stored in the node
    private int next; //index of next  node in the DHT
    private int prev; //index of previous  node in the DHT
    private int index;



    private State state;

    public Node(int id, int data) {
        this.id = id;
        this.data = data;
        this.index = -1;
        this.state =state.DONE;
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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



//    public void passMessageToNextNode(int idSender, int idNewNode, int indexNewNode) {
//        if (isBetween(idNewNode, idSender, this.id)) {
//            this.insertNode(indexNewNode, this.index, this.next);
//            notifyInsertionResult(true, idNewNode);
//            this.setState(State.ARRIVES);
//        }
//        if (isEndOfRing(idNewNode,idSender,this.id)){
//            notifyInsertionResult(true, idNewNode);
//
//        }
//        else {
//            Node nextNode = Nodes.getInstance().findNode(this.next);
//            nextNode.passMessageToNextNode(this.id, idNewNode, indexNewNode);
//        }
//    }
//
//
//
//
//
//
//    public void insertNode(int newNodeIndex, int prevIndex, int nextIndex) {
//        Node newNode = Nodes.getInstance().findNode(newNodeIndex);
//        newNode.setPrev(prevIndex);
//        newNode.setNext(nextIndex);
//
//        Node prevNode = Nodes.getInstance().findNode(prevIndex);
//        prevNode.setNext(newNodeIndex);
//    }
//
//    public void notifyInsertionResult(boolean success, int newNodeIndex) {
//        Node nextNode = Nodes.getInstance().findNode(this.next);
//
//        if (nextNode != null) {
//            nextNode.receiveInsertionResult(success, newNodeIndex);
//        }
//    }
//
//    public void receiveInsertionResult(boolean success, int newNodeIndex) {
//        if (success) {
//            this.setPrev(newNodeIndex);
//            System.out.println("L'insertion du nœud " + newNodeIndex + " a réussi.");
//        } else {
//            System.out.println("L'insertion du nœud " + newNodeIndex + " a échoué.");
//        }
//
//        if(newNodeIndex!=this.index){notifyInsertionResult(success,newNodeIndex);}
//    }
//
//    public void printNode() {
//        System.out.println("Node ID: " + this.id + " Data: " + this.data);
//    }
}