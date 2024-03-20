public class JoinEvent extends Event{
    public JoinEvent(double time, DHTSimulator simulator, Node node) {
        super(time, simulator, node);
    }

    @Override
    public void execute() {
        System.out.println("Noeud" + super.getNode().getId() + " a rejoint le réseau à l'instant " + this.getTime());
    }
}
