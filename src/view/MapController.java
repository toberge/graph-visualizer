package view;

import data.Node;
import data.Vertex;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.GraphModel;

import java.util.LinkedList;

public class MapController {

    @FXML
    private Pane mapPane;

    private GraphModel model = null;

    private static Stage stage = null;

    // necessary? Who knows...
    private LinkedList<Circle> circles = new LinkedList<>();
    private LinkedList<Line> lines = new LinkedList<>();


    public static void setStage(Stage stage) {
        MapController.stage = stage;
    }

    public void initialize() {
        mapPane.setOnMouseMoved((e) -> stage.setTitle(e.getX() + " " + e.getY())); // TODO there shouldn't be such a thing. Is now the only reason there's a stage field here.
        // have it pass in an event handler like NotificationController::trackMouse or whatever
    }

    public void initModel(GraphModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Must only be initialized once!");
        }
        this.model = model;
        model.graphProperty().addListener(observable -> setUp());
        if (model.getGraph() != null) {
            setUp();
        }
    }

    private void setUp() {
        mapPane.getChildren().clear();
        lines.clear();
        circles.clear();
        // at 800x600 positions are scaled 5x, node radius is 15px and line width is 10.
        // radius and stroke properties change based on both height and width:
        // scale factor at 800x600 applied to both, added together and halved to get average.
        for (Node node : model.getGraph().getNodes()) {
            NodeCircle circle = new NodeCircle(mapPane, node);
            circles.add(circle);
            for (Vertex vertex : node.getVertices()) {
                VertexLine line = new VertexLine(mapPane, vertex);
                lines.add(line);
            }
        }
        mapPane.getChildren().addAll(lines);
        mapPane.getChildren().addAll(circles);
    }

    private void refresh() {
        // not necessary at the moment
    }



}
