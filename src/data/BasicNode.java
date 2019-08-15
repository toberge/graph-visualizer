package data;

import java.util.LinkedList;

public class BasicNode {

    private LinkedList<Vertex> vertices = new LinkedList<>();
    // data in subclasses

    public LinkedList<Vertex> getVertices() {
        return vertices;
    }

}