import java.util.*;

// Classe représentant un événement dans la simulation
public abstract class Event implements Comparable<Event> {


    private int receiver;
   private int sender;
   private double time;



    private DHTSimulator simulator;

    public Event( double time, DHTSimulator simulator,int sender,int receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.simulator = simulator;
        this.time = time;

    }
    public int getReceiver() {
        return receiver;
    }





    public int getSender() {
        return sender;
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