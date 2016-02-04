package edu.bsu.storygame;

import edu.bsu.storygame.views.MapView;
import edu.bsu.storygame.views.PlayerCreationView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import react.Slot;


public class MasterUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    final GameContext context = new GameContext();

    @Override
    public void start(final Stage primaryStage) throws Exception {
        context.phase.update(Phase.PLAYER_CREATION);
        primaryStage.setScene(setPlayerCreationScene());
        context.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
                if(context.phase.get().equals(Phase.PLAYER_CREATION)){
                    primaryStage.setScene(setPlayerCreationScene());
                }
                if(context.phase.get().equals(Phase.MOVEMENT)){
                    primaryStage.setScene(setMapViewScene());
                }
            }

        });

        primaryStage.show();
    }
    private Scene setPlayerCreationScene(){
        PlayerCreationView view = new PlayerCreationView(context);
        return view.getPlayerCreationScene();
    }

    private Scene setMapViewScene() {
        MapView view = new MapView(context);
        return view.initMap();
    }
}
