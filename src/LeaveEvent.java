public class LeaveEvent extends Event
{
    public LeaveEvent(double time, DHTSimulator simulator, int sender, int receiver)
    {
        super(time, simulator, sender, receiver);
    }


    @Override
    public void execute()
    {
        //System.out.println("Noeud" + super.getSender().getId() + "a quitté le réseau à l'instant " + this.getTime());
    }
}
