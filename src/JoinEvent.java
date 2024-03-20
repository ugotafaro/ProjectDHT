public class JoinEvent extends Event {

    public JoinEvent(double time, DHTSimulator simulator, Node node) {
        super(time, simulator, node);
    }

    @Override
    public void execute() {
        DHTSimulator simulator = super.getSimulator();
        Node startNode = simulator.getFirstNode();
        joinNetwork(startNode, getNode());
    }

    private void joinNetwork(Node currentNode, Node newNode) {
        DHTSimulator simulator = super.getSimulator();
        int nextNodeIndex = currentNode.getNext();
        Node nextNode = simulator.getNodeByIndex(nextNodeIndex);

        if (nextNode != null && nextNodeIndex != currentNode.getIndex()) {
            if (isBetween(newNode.getId(), currentNode.getId(), nextNode.getId())) {
                // Insertion du nouveau nœud entre le nœud actuel et le suivant
                newNode.setNext(nextNodeIndex);
                newNode.setPrev(currentNode.getIndex());
                currentNode.setNext(newNode.getIndex());
                nextNode.setPrev(newNode.getIndex());
                System.out.println("Le nouveau nœud a été inséré avec succès entre les nœuds " + currentNode.getId() + " et " + nextNode.getId());
            } else {
                // Transmission au nœud suivant pour poursuivre la recherche de l'endroit d'insertion
                joinNetwork(nextNode, newNode);
            }
        } else {
            // Nous avons atteint le dernier nœud, insérer le nouveau nœud pour former un cercle
            if (currentNode.getNext() == 0) { // Vérifier si c'est le premier nœud
                newNode.setNext(currentNode.getIndex());
                newNode.setPrev(currentNode.getIndex());
                currentNode.setNext(newNode.getIndex());
                currentNode.setPrev(newNode.getIndex());
                System.out.println("Le nouveau nœud a été inséré comme premier nœud dans le réseau.");
            } else { // Autrement, former un cercle avec le premier nœud
                Node firstNode = simulator.getFirstNode();
                newNode.setNext(firstNode.getIndex());
                newNode.setPrev(currentNode.getIndex());
                currentNode.setNext(newNode.getIndex());
                firstNode.setPrev(newNode.getIndex());
                System.out.println("Le nouveau nœud a été inséré pour former un cercle. Index du nœud précédent : " + currentNode.getIndex() + ", Index du nœud suivant : " + firstNode.getIndex());
            }
        }
    }




    private boolean isBetween(int id, int start, int end) {
        // Vérifie si l'id est entre start et end (dans l'ordre circulaire)
        if (start <= end) {
            return id > start && id < end;
        } else {
            // L'ordre est circulaire, donc l'id doit être soit plus grand que start, soit plus petit que end
            return id > start || id < end;
        }
    }
}
