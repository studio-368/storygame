package edu.bsu.storygame;

import edu.bsu.storygame.views.EncounterView;
import edu.bsu.storygame.views.GameWinView;
import edu.bsu.storygame.views.MapView;
import edu.bsu.storygame.views.PlayerCreationView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import react.Slot;
import react.UnitSlot;


public class StoryGame extends Application {

    final GameContext context = new GameContext();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        PlayerCreationView view = new PlayerCreationView(context);
        primaryStage.setScene(view.getPlayerCreationScene());

        view.onFinish.connect(new UnitSlot() {
            @Override
            public void onEmit() {
                context.phase.connect(new Slot<Phase>() {
                    @Override
                    public void onEmit(Phase phase) {
                        MapView mapView = new MapView(context);
                        if(context.phase.get().equals(Phase.MOVEMENT)){
                            primaryStage.setScene(new Scene(mapView));
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
                context.phase.update(Phase.MOVEMENT);
            }
        });

        primaryStage.show();
    }

    private Scene setWinningScene(){
        GameWinView view = new GameWinView();
        return view.getWinningScene();
    }

    private boolean checkWinningCondition(Player player){
        if(player.totalPoints.get().equals(context.winningPointTotal.get())){
            return true;
        }
        else {
            return false;

        }
    }
}
