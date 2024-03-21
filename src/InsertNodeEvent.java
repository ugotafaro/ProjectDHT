public class InsertNodeEvent extends Event {
    private int newIndex;

    public InsertNodeEvent(double time, DHTSimulator simulator, int sender, int receiver, int newIndex) {
        super(time, simulator, sender, receiver);
        this.newIndex = newIndex;

    }

    @Override
    public void execute() {
        // Insérer le nouveau noeud en lui donnant les index de next et prev
        System.out.println("Le noeud " + newIndex + " est inséré entre " + super.getSender() + " et " + super.getReceiver() + "");
        Node newNode = Network.getInstance().findNode(newIndex);
        int prevIndexNode = Network.getInstance().findNode(super.getSender()).getIndex();
        int nextIndexNode = Network.getInstance().findNode(super.getReceiver()).getIndex();
        newNode.setNext(nextIndexNode);
        newNode.setPrev(prevIndexNode);
    }
}