package data;

public class Vertex {

    private final Node from, to;

    public Vertex(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        // TODO is this how equality should be decided here?
        return getFrom().getX() == vertex.getFrom().getX() &&
                getFrom().getY() == vertex.getFrom().getY() &&
                getTo().getX() == vertex.getTo().getX() &&
                getTo().getY() == vertex.getTo().getY();
    }
}
