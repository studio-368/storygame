package edu.bsu.storygame;

import edu.bsu.storygame.views.EncounterView;
import edu.bsu.storygame.views.GameWinView;
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
    private EncounterTable encounterTable;

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
                    if(checkWinningCondition(context.players.get(0))){
                        primaryStage.setScene(setWinningScene());
                    }
                    else {
                        primaryStage.setScene(setMapViewScene());
                    }
                }
                if (context.phase.get() == Phase.ENCOUNTER) {
                    Encounter encounter = encounterTable.createEncounter();
                    EncounterView view = new EncounterView(encounter);
                    primaryStage.setScene(new Scene(view));
                }
            }
        });
        encounterTable = new EncounterTable(context);
        primaryStage.show();
    }

    private Scene setPlayerCreationScene(){
        PlayerCreationView view = new PlayerCreationView(context);
        return view.getPlayerCreationScene();
    }

    private Scene setMapViewScene() {
        return new Scene(new MapView(context));

    }

    private Scene setWinningScene(){
        GameWinView view = new GameWinView();
        return view.getWinningScene();
    }

    private boolean checkWinningCondition(Player player){
        return player.totalPoints.get().equals(context.winningPointTotal.get());
    }
}
