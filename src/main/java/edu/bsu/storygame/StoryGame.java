package edu.bsu.storygame;

import edu.bsu.storygame.views.EncounterView;
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
    private MapView mapView = new MapView(context);
    private Scene mapScene = new Scene(mapView);

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
                    mapView.updatePlayerOverlay();
                    primaryStage.setScene(mapScene);
                }
                if (context.phase.get() == Phase.ENCOUNTER) {
                    Encounter encounter;
                    if(context.players.get(0).getRegion() == Regions.Africa){
                        encounter = new EncounterTable().wraithEncounter(context);
                    }
                    else{
                        encounter = new EncounterTable().cockatriceEncounter(context);
                    }

                    EncounterView view = new EncounterView(encounter,context);
                    primaryStage.setScene(new Scene(view));
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
        return new Scene(new MapView(context));

    }
}
