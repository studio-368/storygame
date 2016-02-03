package edu.bsu.storygame.views;

import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import edu.bsu.storygame.Regions;
import edu.bsu.storygame.WraithEncounter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MapView {
    private GameContext gameContext;
    private Button africaRegion = createRegionButton(Regions.Africa, 0,0);
    private Rectangle africaSpace = createPlayerSpace(0, 300);
    private Button europeRegion = createRegionButton(Regions.Europe, 150,150);
    private Rectangle europeSpace = createPlayerSpace(150, 128);
    private Stage mapStage = new Stage();

    public MapView(GameContext gameContext){
        createMapStage(gameContext);
        updateMap();
    }

    private void createMapStage(GameContext gameContext){
        this.gameContext = gameContext;
        mapStage.setScene(initMap());
    }

    public void setRegionTravelButtons(){
        africaRegion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gameContext.player1.setRegion(Regions.Africa);
                new WraithEncounter(gameContext).show();
            }
        });
        europeRegion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                gameContext.player1.setRegion(Regions.Europe);
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
        layout.getChildren().add(africaSpace);
        layout.getChildren().add(europeRegion);
        layout.getChildren().add(europeSpace);
        return mapScene;

    }

    private ImageView createMapImage(){
        ImageView mapImageView = new ImageView(new Image(getClass().getResourceAsStream("/WorldMap.png")));
        mapImageView.setFitHeight(500);
        mapImageView.setFitWidth(500);
        return mapImageView;
    }

    private Button createRegionButton(Regions regionName, double xPosition, double yPosition){
        Button region = new Button(regionName.toString());
        region.setTranslateX(xPosition);
        region.setTranslateY(yPosition);
        return region;
    }

    //TODO figure out why x and y positions aren't translating into the GUI correctly
    private Rectangle createPlayerSpace(double xPosition, double yPosition){
        Rectangle space = new Rectangle(20,20,20,20);
        space.setArcHeight(15);
        space.setArcWidth(15);
        space.setTranslateX(xPosition);
        space.setTranslateY(yPosition);
        space.setFill(Paint.valueOf("red"));
        return space;
    }

    public void updateMap(){
        if(!gameContext.phase.get().equals(Phase.MOVEMENT)){
            africaRegion.setDisable(true);
            europeRegion.setDisable(true);
        }
        else{
            africaRegion.setDisable(false);
            europeRegion.setDisable(false);
        }
    }

    public void showMap(){
        mapStage.show();
    }

}
