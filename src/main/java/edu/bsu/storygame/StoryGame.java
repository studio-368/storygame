package edu.bsu.storygame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StoryGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Spring Studio Project");
        StackPane root = new StackPane();
        root.getChildren().add(new Label("Hello, world"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }
}
