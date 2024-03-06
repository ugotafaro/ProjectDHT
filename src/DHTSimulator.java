import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DHTSimulator {
    private Node firstNode;
    private PriorityQueue<Event> eventQueue;

    public DHTSimulator(Node node) {
        this.firstNode = node;
        eventQueue = new PriorityQueue<>();
    }

    // Méthode pour ajouter un événement à la file d'événements
    private void addEvent(Event event) {
        eventQueue.add(event);
    }


    public void simulate(int endTime) {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();
            if (event.getTime() > endTime) {
                break;
            }
            if (event.getType() == Event.Type.JOIN) {
                join(event.getNode());
            } else if (event.getType() == Event.Type.LEAVE) {
                leave(event.getNode());
            }
        }
    }

    // Méthode pour ajouter un nœud au réseau
    public void join2(Node newNode){

        //cas pour inserer le premier noeud
        if (this.firstNode.getNext()==this.firstNode.getPrev()){
            this.firstNode.setNext(newNode);
            this.firstNode.setPrev(newNode);
            newNode.setPrev(this.firstNode);
            newNode.setNext(this.firstNode);
        }
        //cas si il y a deja plus de 2 noeuds
        else{
            Node currentNode=this.firstNode;
            if (currentNode.getId()<newNode.getId()){
                while (true){
                    if(currentNode.getId()< newNode.getId() && newNode.getId()<currentNode.getNext().getId()){
                        currentNode.setNext(newNode);
                        newNode.setPrev(currentNode);
                        currentNode.getNext().setPrev(newNode);
                        newNode.setNext(currentNode.getNext());
                        break;

                    }
                    if (currentNode.getId()<newNode.getId() && currentNode.getId()>currentNode.getNext().getId())
                        currentNode.setNext(newNode);
                        newNode.setPrev(currentNode);
                        currentNode.getNext().setPrev(newNode);
                        newNode.setNext(currentNode.getNext());
                        break;




                }
                currentNode=currentNode.getNext();
            }
            else{
                while (true){
                    if(currentNode.getId()> newNode.getId() && newNode.getId()>currentNode.getPrev().getId()){
                        currentNode.setPrev(newNode);
                        newNode.setNext(currentNode);
                        currentNode.getPrev().setNext(newNode);
                        newNode.setPrev(currentNode.getPrev());
                        break;

                    }
                    if (currentNode.getId()>newNode.getId() && currentNode.getId()<currentNode.getPrev().getId())
                        currentNode.setPrev(newNode);
                        newNode.setNext(currentNode);
                        currentNode.getPrev().setNext(newNode);
                        newNode.setPrev(currentNode.getPrev());
                    break;




                }
                currentNode=currentNode.getNext();
            }

            }
    }
    public void join(Node newNode) {
        if (nodes.isEmpty()) {
            nodes.add(newNode);
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            System.out.println("Node with ID " + newNode.getId() + " joined the DHT.");
            return;
        }

        Node currentNode = nodes.get(0);
        do {
            // Envoi d'un message au premier nœud de l'anneau
            if (currentNode.getId() == newNode.getId()) {
                Node nextNode = currentNode.getNext();
                if (nextNode.getId() < newNode.getId()) {
                    currentNode = nextNode;
                } else {
                    newNode.setNext(nextNode);
                    newNode.setPrev(currentNode);
                    currentNode.setNext(newNode);
                    nextNode.setPrev(newNode);
                    System.out.println("Node with ID " + newNode.getId() + " joined the DHT.");
                    return;
                }
            }
            currentNode = currentNode.getNext();
        } while (currentNode != nodes.get(0));

        System.out.println("No node found with the given ID.");
    }

    // Méthode pour retirer un nœud du réseau
    public void leave(Node nodeToRemove) {
        if (nodes.size() == 1) {
            nodes.clear();
            nodeToRemove.setNext(null);
            nodeToRemove.setPrev(null);
        } else {
            nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
            nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
            if (nodes.getFirst() == nodeToRemove) {
                nodes.set(0, nodeToRemove.getNext());
            }
        }
        System.out.println("Node with ID " + nodeToRemove.getId() + " left the DHT.");
    }
}

