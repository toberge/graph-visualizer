package model;

import data.Graph;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;

public class GraphModel {

    private final SimpleObjectProperty<Graph> graph = new SimpleObjectProperty<>(null);
    private final SimpleObjectProperty<Object> selectedItem = new SimpleObjectProperty<>(null);

    public GraphModel() {
        if (!load(new File("graphs/test.graph"))) {
            System.err.println("Could not load file; proceeding...");
        }
    }

    public Graph getGraph() {
        return graph.get();
    }

    public SimpleObjectProperty<Graph> graphProperty() {
        return graph;
    }

    public Object getSelectedItem() {
        return selectedItem.get();
    }

    public SimpleObjectProperty<Object> selectedItemProperty() {
        return selectedItem;
    }

    public void setSelectedItem(Object selectedItem) {
        this.selectedItem.set(selectedItem);
    }

    public boolean load(File file) {
        Graph newGraph = Graph.readFromFile(file);
        if (newGraph != null) {
            graph.set(newGraph);
            return true;
        } else {
            return false;
        }
    }

    public boolean store(File file) {
        return false; // TBD && WIP
    }

}
