public class JoinEvent extends Event {
    private int newIndex;

    public JoinEvent(double time, DHTSimulator simulator, int sender, int receiver,int newIndex) {
        super(time, simulator, sender,receiver);
        this.newIndex = newIndex;
    }

    @Override
    public void execute() {joinRequest();

    }
    public void joinRequest(){
        if (super.getSender() !=newIndex){
            if(isBetween(Network.getInstance().findIdByIndex(newIndex),Network.getInstance().findIdByIndex(getSender()),Network.getInstance().findIdByIndex(getReceiver()) )){
                System.out.println("inserer"+newIndex+"entre"+getSender()+"et"+getReceiver()+"");
                insertNode();

            }
            else if(isEndOfRing(Network.getInstance().findIdByIndex(newIndex),Network.getInstance().findIdByIndex(getSender()),Network.getInstance().findIdByIndex(getReceiver()))){
                System.out.println("inserer"+newIndex+"entre"+getSender()+"et"+getReceiver()+"");
                insertNode();

            }
            else{
                //faire un nouvelle event avec le node suivant en tant que sender et son next en tant que receiver
                int nextNodeIndex = Network.getInstance().findNode(super.getReceiver()).getNext();
                System.out.println("passe au suivant");
                JoinEvent newJoinEvent = new JoinEvent(super.getTime(),super.getSimulator(),getReceiver(),nextNodeIndex,newIndex);
                newJoinEvent.execute();

            }


        }
        else{
            System.out.println("passe au suivant");
            int nextNodeIndex = Network.getInstance().findNode(super.getReceiver()).getNext();
            JoinEvent newJoinEvent = new JoinEvent(super.getTime(),super.getSimulator(),getReceiver(),nextNodeIndex,newIndex);
            newJoinEvent.execute();
        }

    }
    public void insertNode(){
        Node newNode = Network.getInstance().findNode(newIndex);
        Node prevNode = Network.getInstance().findNode(super.getSender());
        Node nextNode = Network.getInstance().findNode(super.getReceiver());
        newNode.setNext(nextNode.getIndex());
        newNode.setPrev(prevNode.getIndex());
        prevNode.setNext(newNode.getIndex());
        nextNode.setPrev(newNode.getIndex());
    }
    private boolean isBetween(int id, int start, int end) {
        if (start <= end) {
            return id > start && id < end;
        } else {
            return id > start || id < end;
        }
    }
    private boolean isEndOfRing(int id, int start, int end) {
        if (start >= end) {
            return true;
        } else {
            return false;
        }
    }


}