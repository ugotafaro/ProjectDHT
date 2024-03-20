public class JoinEvent extends Event {
    private int newIndex;

    public JoinEvent(double time, DHTSimulator simulator, int sender, int receiver,int newIndex) {
        super(time, simulator, sender,receiver);
        this.newIndex = newIndex;
    }

    @Override
    public void execute() {

    }
    public void joinRequest(){
        if (super.getSender() !=newIndex){
            if(isBetween(Network.getInstance().findIdByIndex(newIndex),Network.getInstance().findIdByIndex(getSender()),Network.getInstance().findIdByIndex(getReceiver()) )){

            }


        }

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