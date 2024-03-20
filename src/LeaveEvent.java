public class LeaveEvent extends Event
{
    public LeaveEvent(double time, DHTSimulator simulator, Node node)
    {
        super(time, simulator, node);
    }

    @Override
    public void execute()
    {
        System.out.println("Noeud" + super.getNode().getId() + "a quitté le réseau à l'instant " + this.getTime());
    }
}
