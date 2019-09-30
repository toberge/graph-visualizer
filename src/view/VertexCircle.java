package view;

import data.Vertex;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class VertexCircle extends Circle {

    private Vertex vertex;

    public VertexCircle(Pane pane, Vertex vertex) {
        if (pane == null || vertex == null) throw new IllegalArgumentException("Cannot create circle without parent pane and assigned vertex");
        centerXProperty().bind(pane.widthProperty().divide(160).multiply(vertex.getX()));
        centerYProperty().bind(pane.heightProperty().divide(120).multiply(vertex.getY()));
        radiusProperty().bind(pane.widthProperty().divide(53).add(pane.heightProperty().divide(40)).divide(2));
        setOnMouseEntered((e) -> setFill(Paint.valueOf("red")));
        setOnMouseExited((e) -> setFill(Paint.valueOf("black")));
        this.vertex = vertex;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

}
