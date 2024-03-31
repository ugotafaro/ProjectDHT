public class InformPrevEvent extends Event {
    private int newIndex;
    public InformPrevEvent(double time, DHTSimulator simulator, int sender, int receiver,int newIndex) {
        super(time, simulator, sender, receiver);
        this.newIndex = newIndex;

    }

    @Override
    public void execute() {

        // Informer le noeud précédent que le noeud courant va quitter le réseau
        Node prevNode = Network.getInstance().findNode(super.getReceiver());
        prevNode.setNext(Network.getInstance().findNode(super.getSender()).getNext());
        System.out.println("info leave prevLe noeud " + super.getReceiver() + " doit changer son next par le noeud " + newIndex);
        System.out.println("c'est bon ?"+prevNode.getNext());
    }
}