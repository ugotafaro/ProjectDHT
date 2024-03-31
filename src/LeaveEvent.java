public class LeaveEvent extends Event
{
    public LeaveEvent(double time, DHTSimulator simulator, int sender, int receiver)
    {
        super(time, simulator, sender,receiver);
    }


    @Override
    public void execute(){
        System.out.println("Le noeud " + super.getSender() + " a quitté le réseau à l'instant " + this.getTime());

        InformPrevEvent informPrevEvent = new InformPrevEvent(this.getTime(), this.getSimulator(), this.getSender(), Network.getInstance().findNode(this.getSender()).getPrev(),Network.getInstance().findNode(this.getSender()).getNext());
        InformNextEvent informNextEvent = new InformNextEvent(this.getTime(), this.getSimulator(), this.getSender(), Network.getInstance().findNode(this.getSender()).getNext(),Network.getInstance().findNode(this.getSender()).getPrev());

    }


    {
        //System.out.println("Noeud" + super.getSender().getId() + "a quitté le réseau à l'instant " + this.getTime());
    }
}
