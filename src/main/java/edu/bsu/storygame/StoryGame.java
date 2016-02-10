package edu.bsu.storygame;

import edu.bsu.storygame.views.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import react.Slot;
import react.UnitSlot;


public class StoryGame extends Application {

    final GameContext context = new GameContext();
    private Scene mapView;

    public static void main(String[] args) {
        launch(args);
    }

    private EncounterTable encounterTable;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        IntroductionSplashView splashView = new IntroductionSplashView(context);
        primaryStage.setScene(splashView.getIntroductionView());
        splashView.onFinish.connect(new UnitSlot() {
            @Override
            public void onEmit() {
                PlayerCreationView view = new PlayerCreationView(context);
                primaryStage.setScene(view.getPlayerCreationScene());
                view.onFinish.connect(new UnitSlot() {
                    @Override
                    public void onEmit() {
                        context.phase.connect(new Slot<Phase>() {
                            @Override
                            public void onEmit(Phase phase) {
                                if (context.phase.get().equals(Phase.MOVEMENT)) {
                                    boolean win = false;
                                    for (Player player : context.players) {
                                        if(checkWinningCondition(player)){
                                            win = true;
                                            primaryStage.setScene(new GameWinView().getWinningScene(player));
                                        }
                                    }
                                    if (mapView == null) {
                                        mapView = new Scene(new MapView(context));
                                    }
                                    if(!win) {
                                        primaryStage.setScene(mapView);
                                    }
                                }
                                if (context.phase.get() == Phase.ENCOUNTER) {
                                    Encounter encounter = encounterTable.createEncounter();
                                    EncounterView view = new EncounterView(encounter, context);
                                    primaryStage.setScene(new Scene(view));
                                }
                            }

                        });


                        context.phase.update(Phase.MOVEMENT);

                    }
                });
            }
        });
        encounterTable = new EncounterTable(context);
        primaryStage.show();
    }

    private boolean checkWinningCondition(Player player) {
        return player.totalPoints.get().equals(context.winningPointTotal.get());
    }


}
