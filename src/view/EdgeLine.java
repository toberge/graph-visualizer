package view;

import data.Edge;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class EdgeLine extends Line {

    private Edge edge;

    public EdgeLine(Pane pane, Edge edge) {
        if (pane == null || edge == null) throw new IllegalArgumentException("Cannot create line without parent pane and assigned edge");
        startXProperty().bind(pane.widthProperty().divide(160).multiply(edge.getFrom().getX()));
        startYProperty().bind(pane.heightProperty().divide(120).multiply(edge.getFrom().getY()));
        endXProperty().bind(pane.widthProperty().divide(160).multiply(edge.getTo().getX()));
        endYProperty().bind(pane.heightProperty().divide(120).multiply(edge.getTo().getY()));
        strokeWidthProperty().bind(pane.widthProperty().divide(80).add(pane.heightProperty().divide(60)).divide(2));
        setOnMouseEntered((e) -> setStroke(Paint.valueOf("orange")));
        setOnMouseExited((e) -> setStroke(Paint.valueOf("black")));
        this.edge = edge;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

}
