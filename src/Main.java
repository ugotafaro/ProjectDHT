import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Node n1=new Node(1,5);
        Node n2=new Node(2,5);
        Node n3=new Node(3,5);
        //create 4 more nodes
        Node n4=new Node(4,5);
        Node n5=new Node(5,5);
        Node n6=new Node(6,5);
        Node n7=new Node(7,5);


        DHTSimulator dht=new DHTSimulator();


        Event join1=new JoinEvent(1,dht,n4);
        Event join2=new JoinEvent(5,dht,n5);
        Event join3=new JoinEvent(3,dht,n6);

        dht.addEvent(join1);
        dht.addEvent(join2);
        dht.addEvent(join3);

        dht.simulate(15);



    }
}