package edu.bsu.storygame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MapView {
    GameContext gameContext;
    Button africaRegion = createRegion("New Africa", 0,0);
    Button europeRegion = createRegion("New Europe", 150,150);

    MapView(GameContext gameContext){
        this.gameContext = gameContext;

    }

    public Stage mapStage(){
        Stage mapScreen = new Stage();
        mapScreen.setScene(initMap());
        return mapScreen;
    }

    public void setRegionTravelButtons(){
        africaRegion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gameContext.player1.setRegion("New Africa");
                new WraithEncounter(gameContext).show();
            }
        });
        europeRegion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gameContext.player1.setRegion("New Europe");
                new WraithEncounter(gameContext).show();
            }
        });
    }


    private Scene initMap(){
        StackPane layout = new StackPane();
        Scene mapScene = new Scene(layout,500,500);
        setRegionTravelButtons();
        layout.getChildren().add(createMapImage());
        layout.getChildren().add(africaRegion);
        layout.getChildren().add(europeRegion);

        if(!gameContext.phase.get().equals(Phase.MOVEMENT)){
            africaRegion.setDisable(true);
            europeRegion.setDisable(true);
        }
        else{
            africaRegion.setDisable(false);
            europeRegion.setDisable(false);
        }
        return mapScene;

    }

    private ImageView createMapImage(){
        ImageView mapImageView = new ImageView(new Image(getClass().getResourceAsStream("/WorldMap.png")));
        mapImageView.setFitHeight(500);
        mapImageView.setFitWidth(500);
        return mapImageView;
    }

    private Button createRegion(String regionName, double xPosition, double yPosition){
        Button region = new Button(regionName);
        region.setTranslateX(xPosition);
        region.setTranslateY(yPosition);
        return region;
    }

}
