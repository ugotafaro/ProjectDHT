import java.util.*;

// Classe représentant un événement dans la simulation
public abstract class Event implements Comparable<Event> {

   private Node node;
   private double time;

   private DHTSimulator simulator;

    public Event( double time, DHTSimulator simulator,Node node) {
        this.node = node;
        this.simulator = simulator;
        this.time = time;

    }



    public Node getNode() {
        return node;
    }

    public double getTime() {
        return time;
    }

    public abstract void execute();


    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);

    }
}