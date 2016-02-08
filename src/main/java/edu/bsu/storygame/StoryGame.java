package edu.bsu.storygame;

import edu.bsu.storygame.views.EncounterView;
import edu.bsu.storygame.views.MapView;
import edu.bsu.storygame.views.PlayerCreationView;
import edu.bsu.storygame.views.StoryIntroView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import react.Slot;

public class StoryGame extends Application {

    final GameContext context = new GameContext();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        context.phase.update(Phase.PLAYER_CREATION);
        primaryStage.setScene(setPlayerCreationScene());
       Scene mapScene = new Scene(new MapView(context));
        context.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
                if(context.phase.get().equals(Phase.PLAYER_CREATION)){
                    primaryStage.setScene(setPlayerCreationScene());
                }
                if(context.phase.get().equals(Phase.MOVEMENT)) {
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
                if (context.phase.get() == Phase.STORY) {
                    StoryIntroView storyIntro = new StoryIntroView();
                    primaryStage.setScene(new Scene(storyIntro));
                }

            }

        });

        primaryStage.show();
    }
    private Scene setPlayerCreationScene(){
        PlayerCreationView view = new PlayerCreationView(context);
        return view.getPlayerCreationScene();
    }

}
