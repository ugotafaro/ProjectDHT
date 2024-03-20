import java.util.ArrayList;

public class Nodes {


    private ArrayList<Node> nodes;
    public Nodes() {
        nodes = new ArrayList<>();
    }
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    public void addNode(Node node) {
        node.setIndex(this.nodes.size());
        this.nodes.add(node);

    }
    public Node findNode(int index){
        return this.nodes.get(index);
    }
}
