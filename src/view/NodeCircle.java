package view;

import data.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class NodeCircle extends Circle {

    private Node node;

    public NodeCircle(Pane pane, Node node) {
        if (pane == null || node == null) throw new IllegalArgumentException("Cannot create circle without parent pane and assigned node");
        centerXProperty().bind(pane.widthProperty().divide(160).multiply(node.getX()));
        centerYProperty().bind(pane.heightProperty().divide(120).multiply(node.getY()));
        radiusProperty().bind(pane.widthProperty().divide(53).add(pane.heightProperty().divide(40)).divide(2));
        setOnMouseEntered((e) -> setFill(Paint.valueOf("red")));
        setOnMouseExited((e) -> setFill(Paint.valueOf("black")));
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

}
