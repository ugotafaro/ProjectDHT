import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node n1=new Node(1,5);
        Node n2=new Node(2,5);
        Node n3=new Node(3,5);

        DHTSimulator dht=new DHTSimulator();

        dht.addNode(n1);
        dht.addNode(n2);
        dht.addNode(n3);

        System.out.println(dht.getNodes());
        System.out.println(n2.getIndex());




    }
}