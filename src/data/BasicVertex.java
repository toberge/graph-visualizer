package data;

import java.util.LinkedList;

public class BasicVertex {

    private LinkedList<Edge> edges = new LinkedList<>();
    // data in subclasses

    public LinkedList<Edge> getEdges() {
        return edges;
    }

}