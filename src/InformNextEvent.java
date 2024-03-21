public class InformNextEvent extends Event {
    public InformNextEvent(double time, DHTSimulator simulator, int sender, int receiver) {
        super(time, simulator, sender, receiver);
        simulator.addEvent(this);
    }

    @Override
    public void execute() {
        // Informer le noeud suivant que le noeud courant va quitter le réseau
        Node nextNode = Network.getInstance().findNode(super.getReceiver());
        nextNode.setPrev(Network.getInstance().findNode(super.getSender()).getPrev());
        System.out.println("Le noeud " + super.getReceiver() + " doit changer son prev par le noeud " + Network.getInstance().findNode(super.getSender()).getPrev());

    }
}
