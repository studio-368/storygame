package edu.bsu.storygame.views;

import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import edu.bsu.storygame.Player;
import edu.bsu.storygame.Regions;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import react.Slot;

public class MapView extends StackPane {

    private final Button africaRegion = createRegionButton(Regions.Africa, 0,50);
    private final Button europeRegion = createRegionButton(Regions.Europe, 0,-25);
    private GameContext context;

    private Rectangle europeSpace;
    private Rectangle europeSpace2;
    private Rectangle africaSpace;
    private Rectangle africaSpace2;
    private HBox hBox = new HBox();
    private Label turn = new Label();

    public MapView(GameContext context){
        this.context = context;


        europeSpace = createPlayerSpace(-10, -50, context.players.get(0).getPlayerColor());
        europeSpace2 = createPlayerSpace(10, -50, context.players.get(1).getPlayerColor());

        africaSpace = createPlayerSpace(-10, 25, context.players.get(0).getPlayerColor());
        africaSpace2 = createPlayerSpace(10, 25, context.players.get(1).getPlayerColor());
        africaSpace.setVisible(false);
        africaSpace2.setVisible(false);

        context.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
                updateButtonStatus(phase);
            }
        });
        updateButtonStatus(context.phase.get());
        this.initMap();
        context.currentPlayer.connect(new Slot<Integer>() {
            @Override
            public void onEmit(Integer integer) {
                turn.setText(context.players.get(context.currentPlayer.get()).getName() + "'s turn!");
                turn.setTextFill(context.players.get(context.currentPlayer.get()).getPlayerColor());
            }
        });
    }

    private void initMap(){
        this.setRegionTravelButtons();
        this.getChildren().add(createMapImage());
        this.getChildren().add(africaRegion);
        this.getChildren().add(europeRegion);
        this.getChildren().add(europeSpace);
        this.getChildren().add(europeSpace2);
        this.getChildren().add(africaSpace);
        this.getChildren().add(africaSpace2);
        hBox.setTranslateY(425);
        this.getChildren().add(turn);
        turn.setTranslateX(0);
        turn.setTranslateY(150);
        this.getChildren().add(hBox);
        for (Player player: context.players) {
            hBox.getChildren().add(new PlayerView(player));
        }

        turn.setText(context.players.get(context.currentPlayer.get()).getName() + "'s turn!");
        turn.setTextFill(context.players.get(context.currentPlayer.get()).getPlayerColor());
    }

    private void setRegionTravelButtons(){
        africaRegion.setOnAction(event -> {
                if(context.currentPlayer.get() == 0) {
                    setPlayerPosition(europeSpace, africaSpace);
                    context.players.get(0).setRegion(Regions.Africa);
                }
                else{
                    setPlayerPosition(europeSpace2,africaSpace2);
                    context.players.get(1).setRegion(Regions.Africa);

                }
            context.phase.update(Phase.ENCOUNTER);

        });
        europeRegion.setOnAction(event -> {
                if(context.currentPlayer.get() == 0) {
                    setPlayerPosition(africaSpace, europeSpace);
                    context.players.get(0).setRegion(Regions.Europe);
                }
                else{
                    setPlayerPosition(africaSpace2,europeSpace2);
                    context.players.get(1).setRegion(Regions.Europe);
                }
            context.phase.update(Phase.ENCOUNTER);
        });

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

    private Rectangle createPlayerSpace(double xPosition, double yPosition, Color playerColor){
        Rectangle space = new Rectangle(20,20);
        space.setArcHeight(15);
        space.setArcWidth(15);
        space.setTranslateX(xPosition);
        space.setTranslateY(yPosition);
        space.setFill(playerColor);
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