package model;

import data.Graph;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

public class GraphModel {

    private final SimpleObjectProperty<Graph> graph = new SimpleObjectProperty<>(null);
    private final SimpleObjectProperty<Object> selectedItem = new SimpleObjectProperty<>(null);
    private final ObservableList<Object> markedItems = FXCollections.observableArrayList();
    private final SimpleIntegerProperty markedNow = new SimpleIntegerProperty(-1);
    // TODO implement path marking that listens to this list and marks nodes and vertices accordingly

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

    public ObservableList<Object> getMarkedItems() {
        return markedItems;
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
