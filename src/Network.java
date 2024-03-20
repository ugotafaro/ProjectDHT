import java.util.ArrayList;

public class Network {
    private static Network instance = null;
    private ArrayList<Node> nodes;

    private Network() {
        nodes = new ArrayList<>();
    }

    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        node.setIndex(this.nodes.size());
        this.nodes.add(node);
    }

    public Node findNode(int index){
        return this.nodes.get(index);
    }
    public int findIdByIndex(int index){
        return this.nodes.get(index).getId();
    }
}