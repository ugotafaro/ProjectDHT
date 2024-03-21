public class ValidateInsertionEvent extends Event {
    private int newIndex;

    public ValidateInsertionEvent(double time, DHTSimulator simulator, int sender, int receiver, int newIndex) {
        super(time, simulator, sender, receiver);
        this.newIndex = newIndex;

    }

    @Override
    public void execute() {
        // Informer le noeud sender qu'il peut changer son next par le nouveau noeud
        System.out.println("Le noeud " + super.getSender() + " peut changer son next par le noeud " + newIndex);
        Node senderNode = Network.getInstance().findNode(super.getSender());
        senderNode.setNext(newIndex);
    }
}