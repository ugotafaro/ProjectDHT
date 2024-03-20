import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        // Créer et ajouter des nœuds au simulateur
        Node node1 = new Node(1, 10);
        Node node2 = new Node(2, 20);
        Node node3 = new Node(3, 30);
        Nodes nodes = new Nodes();
        nodes.addNode(node1);
        nodes.addNode(node2);
        nodes.addNode(node3);
        System.out.println("ffffff");
        System.out.println(node1.getIndex());
        System.out.println(node2.getIndex());
        System.out.println(node3.getIndex());
        System.out.println(nodes.getNodes());

        DHTSimulator simulator = new DHTSimulator(node1);

//        // Planifier l'événement de join pour chaque nœud à un temps spécifique
//        simulator.addEvent(new JoinEvent(5, simulator, node1));
//        simulator.addEvent(new JoinEvent(10, simulator, node2));
//        simulator.addEvent(new JoinEvent(15, simulator, node3));
//
//        // Exécuter la simulation jusqu'à ce que le temps spécifié soit écoulé
//        simulator.simulate(20);
//
//
//        System.out.println(node1.getNext());
//        System.out.println(node2.getNext());
//        System.out.println(simulator.getNodes());
//        System.out.println(node3.getNext());



    }
}