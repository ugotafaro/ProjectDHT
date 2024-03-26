import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        // Créer et ajouter des nœuds au simulateur
        Node node1 = new Node(1, 10);
        Node node2 = new Node(2, 20);
        Node node3 = new Node(3, 30);
        Node node4 = new Node(4, 40);
        Node node5 = new Node(5, 50);
        Node node6 = new Node(6, 60);
        Node node7 = new Node(7, 70);
        Network nodes = Network.getInstance();
        nodes.addNode(node1);
        nodes.addNode(node2);
        nodes.addNode(node3);
        nodes.addNode(node4);
        nodes.addNode(node5);
        nodes.addNode(node6);
        nodes.addNode(node7);
        System.out.println("ffffff");
        System.out.println(node1.getIndex());
        System.out.println(node2.getIndex());
        System.out.println(node3.getIndex());
        System.out.println(nodes.getNodes());

        DHTSimulator simulator = new DHTSimulator(node1);


        JoinEvent j1=(new JoinEvent(5, simulator, node2.getIndex(),simulator.getNode().getIndex(),node2.getIndex()));
        JoinEvent j2=(new JoinEvent(10, simulator, node3.getIndex(),simulator.getNode().getIndex(),node3.getIndex()));
        //JoinEvent j3=(new JoinEvent(15, simulator, node4.getIndex(),simulator.getNode().getIndex(),node4.getIndex()));
        //JoinEvent j4=(new JoinEvent(20, simulator, node5.getIndex(),simulator.getNode().getIndex(),node5.getIndex()));
        //JoinEvent j5=(new JoinEvent(25, simulator, node6.getIndex(),simulator.getNode().getIndex(),node6.getIndex()));
        //LeaveEvent l1=(new LeaveEvent(30,simulator,node2.getIndex(), node2.getIndex()));
        JoinEvent j6=(new JoinEvent(35, simulator, node7.getIndex(),simulator.getNode().getIndex(),node7.getIndex()));
        LeaveEvent l2=(new LeaveEvent(40,simulator,node7.getIndex(),simulator.getNode().getIndex()));


        // Exécuter la simulation jusqu'à ce que le temps spécifié soit écoulé
        simulator.simulate(50);


        System.out.println(node1.getNext());
        System.out.println(node2.getNext());

        System.out.println(node3.getNext());



    }
}