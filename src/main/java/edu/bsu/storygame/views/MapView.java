package edu.bsu.storygame.views;

import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import edu.bsu.storygame.Player;
import edu.bsu.storygame.Regions;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import react.Slot;

import java.util.ArrayList;
import java.util.List;

public class MapView extends StackPane {

    private GameContext gameContext;
    private final Button africaRegion = createRegionButton(Regions.Africa, 0,50);
    private Rectangle africaSpace = createPlayerSpace(0, 29);
    private final Button europeRegion = createRegionButton(Regions.Europe, 0,-25);
    private Rectangle europeSpace = createPlayerSpace(0, -46);


    public MapView(GameContext gameContext){
        this.gameContext = gameContext;
        gameContext.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
                updateButtonStatus(phase);
            }
        });
        updateButtonStatus(gameContext.phase.get());
        this.initMap();
    }

    private void setRegionTravelButtons(){
        africaRegion.setOnAction(event -> {
            if(!africaSpace.isVisible()){
                setPlayerPosition(europeSpace,africaSpace);

            }
            gameContext.player1.setRegion(Regions.Africa);
            gameContext.phase.update(Phase.ENCOUNTER);

        });
        europeRegion.setOnAction(event -> {
            if(!europeSpace.isVisible()){
                setPlayerPosition(africaSpace,europeSpace);
            }
            gameContext.player1.setRegion(Regions.Europe);
            gameContext.phase.update(Phase.ENCOUNTER);
        });
    }

    private void initMap(){
        this.setRegionTravelButtons();
        this.getChildren().add(createMapImage());
        this.getChildren().add(africaRegion);
        this.getChildren().add(africaSpace);
        this.getChildren().add(europeRegion);
        this.getChildren().add(europeSpace);
        setPlayerPosition(europeSpace,europeSpace);
        HBox hBox = new HBox();
        PlayerView player1View = new PlayerView(gameContext.players.get(0));
        hBox.getChildren().add(player1View);
        hBox.setTranslateY(425);
        this.getChildren().add(hBox);
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

    private Rectangle createPlayerSpace(double xPosition, double yPosition){
        Rectangle space = new Rectangle(20,20);
        space.setArcHeight(15);
        space.setArcWidth(15);
        space.setTranslateX(xPosition);
        space.setTranslateY(yPosition);
        space.setFill(Color.RED);
        space.setVisible(false);
        return space;
    }

    private void setPlayerPosition(Rectangle playerCurrentSpace, Rectangle playerNewSpace){
        playerCurrentSpace.setVisible(false);
        playerNewSpace.setVisible(true);
    }

    private void updateButtonStatus(Phase phase){
        if(!phase.equals(Phase.MOVEMENT)){
            africaRegion.setDisable(true);
            europeRegion.setDisable(true);
        }
        else{
            africaRegion.setDisable(false);
            europeRegion.setDisable(false);
        }
    }
}