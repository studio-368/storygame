package edu.bsu.storygame.views;


import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import react.Slot;

public class IntroductionView{

    ImageView imageView;
    Image image;
    GameContext context;
    GridPane grid;

    public IntroductionView(GameContext context){
        this.context = context;
        context.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
            }
        });
    }

    public Scene getIntroductionView(){
        initGrid();
        initImage();
        addUIVariables();
        return new Scene(grid);
    }

    private void initGrid(){
        grid = new GridPane();
        grid.setMinSize(300,500);
        grid.setVgap(15);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setOnMouseClicked(e -> handleEvent());
    }

    private void initImage(){
        image = new Image("Intro.png");
        imageView = new ImageView();
        imageView.setImage(image);
    }

    private void addUIVariables(){
        grid.getChildren().add(imageView);
    }

    private void handleEvent(){
        context.phase.update(Phase.PLAYER_CREATION);
    }
}
