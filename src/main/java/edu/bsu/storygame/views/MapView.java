package edu.bsu.storygame.views;

import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import edu.bsu.storygame.Regions;
import edu.bsu.storygame.WraithEncounter;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import react.Slot;

public class MapView extends StackPane{

    private GameContext gameContext;
    private final Button africaRegion = createRegionButton(Regions.Africa, 0,0);
    private Rectangle africaSpace = createPlayerSpace(0, -22);
    private final Button europeRegion = createRegionButton(Regions.Europe, 150,150);
    private Rectangle europeSpace = createPlayerSpace(150, 128);


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
            new WraithEncounter(gameContext).show();

        });
        europeRegion.setOnAction(event -> {
            if(!europeSpace.isVisible()){
                setPlayerPosition(africaSpace,europeSpace);
            }
            gameContext.player1.setRegion(Regions.Europe);
            new WraithEncounter(gameContext).show();
        });
    }

    private void initMap(){
        this.setRegionTravelButtons();
        this.getChildren().add(createMapImage());
        this.getChildren().add(africaRegion);
        this.getChildren().add(africaSpace);
        this.getChildren().add(europeRegion);
        this.getChildren().add(europeSpace);
        setPlayerPosition(africaSpace,africaSpace);
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