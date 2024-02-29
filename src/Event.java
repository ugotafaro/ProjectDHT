import java.util.*;

// Classe représentant un événement dans la simulation
class Event implements Comparable<Event> {
    public enum Type {
        JOIN, LEAVE
    }

    private Type type;
    private Node node;
    private int time;

    public Event(Type type, Node node, int time) {
        this.type = type;
        this.node = node;
        this.time = time;
    }

    public Type getType() {
        return type;
    }

    public Node getNode() {
        return node;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.time, other.time);
    }
}