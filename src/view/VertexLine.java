package view;

import data.Vertex;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class VertexLine extends Line {

    private Vertex vertex;

    public VertexLine(Pane pane, Vertex vertex) {
        if (pane == null || vertex == null) throw new IllegalArgumentException("Cannot create line without parent pane and assigned vertex");
        startXProperty().bind(pane.widthProperty().divide(160).multiply(vertex.getFrom().getX()));
        startYProperty().bind(pane.heightProperty().divide(120).multiply(vertex.getFrom().getY()));
        endXProperty().bind(pane.widthProperty().divide(160).multiply(vertex.getTo().getX()));
        endYProperty().bind(pane.heightProperty().divide(120).multiply(vertex.getTo().getY()));
        strokeWidthProperty().bind(pane.widthProperty().divide(80).add(pane.heightProperty().divide(60)).divide(2));
        setOnMouseEntered((e) -> setStroke(Paint.valueOf("orange")));
        setOnMouseExited((e) -> setStroke(Paint.valueOf("black")));
        this.vertex = vertex;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

}
