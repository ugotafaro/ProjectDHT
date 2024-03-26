public class InformNextEvent extends Event {
    private int newIndex;
    public InformNextEvent(double time, DHTSimulator simulator, int sender, int receiver,int newIndex) {
        super(time, simulator, sender, receiver);
        this.newIndex = newIndex;
        simulator.addEvent(this);
    }

    @Override
    public void execute() {
        // Informer le noeud suivant que le noeud courant va quitter le réseau
        Node nextNode = Network.getInstance().findNode(super.getReceiver());
        nextNode.setPrev(Network.getInstance().findNode(super.getSender()).getPrev());
        System.out.println("info leave next Le noeud " + super.getReceiver() + " doit changer son prev par le noeud " +newIndex);
        System.out.println("c'est bon ?"+nextNode.getPrev());
    }
}
