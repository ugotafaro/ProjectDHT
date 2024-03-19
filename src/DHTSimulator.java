import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DHTSimulator {

    private ArrayList<Node> nodes;
    private PriorityQueue<Event> eventQueue;

    public DHTSimulator() {
        nodes = new ArrayList<>();
        eventQueue = new PriorityQueue<>();
    }

    // Méthode pour ajouter un événement à la file d'événements
    private void addEvent(Event event) {
        eventQueue.add(event);
    }

    public void addNode(Node node) {
        System.out.println(this.nodes.size());
        node.setIndex(this.nodes.size());
        this.nodes.add(node);

    }
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

}

//    public void simulate(int endTime) {
//        while (!eventQueue.isEmpty()) {
//            Event event = eventQueue.poll();
//            if (event.getTime() > endTime) {
//                break;
//            }
//            if (event.getType() == Event.Type.JOIN) {
//                join(event.getNode());
//            } else if (event.getType() == Event.Type.LEAVE) {
//                leave(event.getNode());
//            }
//        }
//    }
//}
    // Méthode pour ajouter un nœud au réseau
//    public void join(Node newNode) {
//       if (nodes.isEmpty()) {
//            nodes.add(newNode);
//            newNode.setNext(newNode);
//            newNode.setPrev(newNode);
//            System.out.println("Node with ID " + newNode.getId() + " joined the DHT.");
//            return;
//        }
//
//        Node currentNode = nodes.get(0);
//        do {
//            // Envoi d'un message au premier nœud de l'anneau
//            if (currentNode.getId() == newNode.getId()) {
//                Node nextNode = currentNode.getNext();
//                if (nextNode.getId() < newNode.getId()) {
//                    currentNode = nextNode;
//                } else {
//                    newNode.setNext(nextNode);
//                    newNode.setPrev(currentNode);
//                    currentNode.setNext(newNode);
//                    nextNode.setPrev(newNode);
//                    System.out.println("Node with ID " + newNode.getId() + " joined the DHT.");
//                    return;
//                }
//            }
//            currentNode = currentNode.getNext();
//        } while (currentNode != nodes.get(0));
//
//        System.out.println("No node found with the given ID.");
//    }
//
//    // Méthode pour retirer un nœud du réseau
//    public void leave(Node nodeToRemove) {
//        if (nodes.size() == 1) {
//            nodes.clear();
//            nodeToRemove.setNext(null);
//            nodeToRemove.setPrev(null);
//        } else {
//            nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
//            nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
//            if (nodes.getFirst() == nodeToRemove) {
//                nodes.set(0, nodeToRemove.getNext());
//            }
//        }
//        System.out.println("Node with ID " + nodeToRemove.getId() + " left the DHT.");
//
//    }
//}

