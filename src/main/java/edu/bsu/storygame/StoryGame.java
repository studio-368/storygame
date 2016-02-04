package edu.bsu.storygame;

import edu.bsu.storygame.views.MapView;
import edu.bsu.storygame.views.PlayerCreationView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import react.Slot;


public class StoryGame extends Application {

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
                if(context.phase.get().equals(Phase.ENCOUNTER)){
                    showEncounterView();
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

    private void showEncounterView(){
        new WraithEncounter(context).show();
    }
}