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
                System.out.println("node index"+getReceiver()+"a changer son prev par le node index"+newIndex);
                Network.getInstance().findNode(super.getSender()).setPrev(newIndex);
                insertNode();

            }
            else if(isEndOfRing(Network.getInstance().findIdByIndex(newIndex),Network.getInstance().findIdByIndex(getSender()),Network.getInstance().findIdByIndex(getReceiver()))){
                System.out.println("node index"+getReceiver()+"a changer son prev par le node index"+newIndex);
                Network.getInstance().findNode(super.getSender()).setPrev(newIndex);
                insertNode();

            }
            else{
                //faire un nouvelle event avec le node suivant en tant que sender et son next en tant que receiver
                int nextNodeIndex = Network.getInstance().findNode(super.getReceiver()).getNext();

                JoinEvent newJoinEvent = new JoinEvent(super.getTime(),super.getSimulator(),getReceiver(),nextNodeIndex,newIndex);


            }


        }
        else{

            int nextNodeIndex = Network.getInstance().findNode(super.getReceiver()).getNext();
            JoinEvent newJoinEvent = new JoinEvent(super.getTime(),super.getSimulator(),getReceiver(),nextNodeIndex,newIndex);

        }

    }
    public void insertNode(){
        // Créer et exécuter un InsertNodeEvent
        InsertNodeEvent insertNodeEvent = new InsertNodeEvent(super.getTime(), super.getSimulator(), getSender(), getReceiver(), newIndex);
        insertNodeEvent.execute();

        // Créer et exécuter un ValidateInsertionEvent

        ValidateInsertionEvent validateInsertionEvent = new ValidateInsertionEvent(super.getTime(), super.getSimulator(), getSender(), getReceiver(), newIndex);
        validateInsertionEvent.execute();
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