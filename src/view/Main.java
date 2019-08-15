package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.GraphModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();

        FXMLLoader mapLoader = new FXMLLoader(getClass().getResource("map.fxml"));
        root.setCenter(mapLoader.load());
        MapController mapController = mapLoader.getController();

        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menu_bar.fxml"));
        root.setTop(menuLoader.load());
        MenuController menuController = menuLoader.getController();

        GraphModel model = new GraphModel();
        MapController.setStage(primaryStage);
        mapController.initModel(model);
        menuController.initModel(model);

        primaryStage.setTitle("Get Graphic");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
