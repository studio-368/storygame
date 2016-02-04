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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import react.Slot;

public class MapView {
    private GameContext gameContext;
    public final Button africaRegion = createRegionButton(Regions.Africa, 0, 0);
    private Rectangle africaSpace = createPlayerSpace(0, -22);
    public final Button europeRegion = createRegionButton(Regions.Europe, 150, 150);
    private Rectangle europeSpace = createPlayerSpace(150, 128);
    private Stage mapStage = new Stage();


    public MapView(GameContext gameContext) {
        this.gameContext = gameContext;
        gameContext.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
                updateButtonStatus(phase);
            }
        });
        updateButtonStatus(gameContext.phase.get());
        createMapStage(gameContext);
    }

    private void createMapStage(GameContext gameContext) {
        this.gameContext = gameContext;
        mapStage.setScene(initMap());
    }

    public void setRegionTravelButtons() {
        africaRegion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!africaSpace.isVisible()) {
                    setPlayerPosition(europeSpace, africaSpace);

                }
                gameContext.player1.setRegion(Regions.Africa);
                new WraithEncounter(gameContext).show();

            }
        });
        europeRegion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!europeSpace.isVisible()) {
                    setPlayerPosition(africaSpace, europeSpace);
                }
                gameContext.player1.setRegion(Regions.Europe);
                new WraithEncounter(gameContext).show();
            }

        });
    }


    private Scene initMap() {
        StackPane layout = new StackPane();
        Scene mapScene = new Scene(layout, 500, 500);
        setRegionTravelButtons();
        layout.getChildren().add(createMapImage());
        layout.getChildren().add(africaRegion);
        layout.getChildren().add(africaSpace);
        layout.getChildren().add(europeRegion);
        layout.getChildren().add(europeSpace);
        setPlayerPosition(africaSpace, africaSpace);
        return mapScene;

    }

    private ImageView createMapImage() {
        ImageView mapImageView = new ImageView(new Image(getClass().getResourceAsStream("/WorldMap.png")));
        mapImageView.setFitHeight(500);
        mapImageView.setFitWidth(500);
        return mapImageView;
    }

    private Button createRegionButton(Regions regionName, double xPosition, double yPosition) {
        Button region = new Button(regionName.toString());
        region.setTranslateX(xPosition);
        region.setTranslateY(yPosition);
        return region;
    }

    private Rectangle createPlayerSpace(double xPosition, double yPosition) {
        Rectangle space = new Rectangle(20, 20);
        space.setArcHeight(15);
        space.setArcWidth(15);
        space.setTranslateX(xPosition);
        space.setTranslateY(yPosition);
        space.setFill(Color.RED);
        space.setVisible(false);
        return space;
    }

    private void setPlayerPosition(Rectangle playerCurrentSpace, Rectangle playerNewSpace) {
        playerCurrentSpace.setVisible(false);
        playerNewSpace.setVisible(true);
    }

    public void updateButtonStatus(Phase phase) {
        if (!phase.equals(Phase.MOVEMENT)) {
            africaRegion.setDisable(true);
            europeRegion.setDisable(true);
        } else {
            africaRegion.setDisable(false);
            europeRegion.setDisable(false);
        }
    }

    public Stage mapStage() {
        return mapStage;
    }

    public void showMap() {
        mapStage.show();
    }

}
