package data;

public class Edge {

    private final Vertex from, to;

    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        // TODO is this how equality should be decided here?
        return getFrom().getX() == edge.getFrom().getX() &&
                getFrom().getY() == edge.getFrom().getY() &&
                getTo().getX() == edge.getTo().getX() &&
                getTo().getY() == edge.getTo().getY();
    }
}
