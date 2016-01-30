package edu.bsu.storygame;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MapView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initMap(createMapImage());
    }


    private void initMap(ImageView mapImageView){
        StackPane layout = new StackPane(mapImageView);
        layout.getChildren().add(layout);

    }

    private ImageView createMapImage(){
        ImageView mapImageView = new ImageView(new Image(getClass().getResourceAsStream("/WorldMap.png")));
        mapImageView.setFitHeight(500);
        mapImageView.setFitWidth(500);
        return mapImageView;

    }


}
