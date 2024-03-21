public class InformPrevEvent extends Event {
    public InformPrevEvent(double time, DHTSimulator simulator, int sender, int receiver) {
        super(time, simulator, sender, receiver);
        simulator.addEvent(this);
    }

    @Override
    public void execute() {

        // Informer le noeud précédent que le noeud courant va quitter le réseau
        Node prevNode = Network.getInstance().findNode(super.getReceiver());
        prevNode.setNext(Network.getInstance().findNode(super.getSender()).getNext());
        System.out.println("Le noeud " + super.getReceiver() + " doit changer son next par le noeud " + Network.getInstance().findNode(super.getSender()).getNext());
    }
}