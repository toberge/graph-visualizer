package view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import model.GraphModel;

import java.io.File;

public class MenuController {

    @FXML
    private MenuBar menuBar;

    private GraphModel model = null;

    public void initModel(GraphModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Must only be initialized once!");
        }
        this.model = model;
    }

    public void handleOpen() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose a Graph");
        chooser.setInitialDirectory(new File("graphs/"));
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        if (file != null) model.load(file);
    }

    public void handleSave() {
        System.out.println("We save");
    }

    public void handleSaveAs() {
        System.out.println("We save an ass");
    }

    public void handleQuit() {
        System.out.println("Quitting...");
        System.exit(0); // TODO exit softly
    }

    public void handleStepForward() {
        System.out.println("TODO");
    }
}
