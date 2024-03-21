public class LeaveEvent extends Event
{
    public LeaveEvent(double time, DHTSimulator simulator, int sender, int receiver)
    {
        super(time, simulator, sender,receiver);
    }


    @Override
    public void execute(){
        InformPrevEvent informPrevEvent = new InformPrevEvent(this.getTime(), this.getSimulator(), this.getSender(), Network.getInstance().findNode(this.getSender()).getPrev());
        InformNextEvent informNextEvent = new InformNextEvent(this.getTime(), this.getSimulator(), this.getSender(), Network.getInstance().findNode(this.getSender()).getNext());
        informPrevEvent.execute();
        informNextEvent.execute();
    }


    {
        //System.out.println("Noeud" + super.getSender().getId() + "a quitté le réseau à l'instant " + this.getTime());
    }
}
