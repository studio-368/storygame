package edu.bsu.storygame.views;

import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Player;
import edu.bsu.storygame.Skill;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CreatePlayerView{

    GameContext gameContext;
    Label nameLabel = initLabelPosition("Character Created", 0, -50);
    Button createButton = initButtonPosition("Create", 0, 100);
    TextField characterNameInput = new TextField();
    List<Player> playerList;
    StackPane layout;

    CreatePlayerView(GameContext gameContext){
        this.gameContext = gameContext;
    }

    public Stage creationStage(){
        Stage creationScreen = new Stage();
        creationScreen.setScene(initCreationScreen());
        return creationScreen;
    }

    private Scene initCreationScreen(){
        layout = new StackPane();
        Scene creationScene = new Scene(layout,500,500);
        setCreationButton();
        playerList = new ArrayList<Player>();
        layout.getChildren().add(createButton);
        layout.getChildren().add(characterNameInput);
        return creationScene;
    }

    public void setCreationButton() {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createDefaultPlayer();
                layout.getChildren().add(nameLabel);
                //Show Player View Here
            }
        });
    }

    private Button initButtonPosition(String buttonName, double xPosition, double yPosition){
        Button position = new Button(buttonName);
        position.setTranslateX(xPosition);
        position.setTranslateY(yPosition);
        return position;
    }

    private Label initLabelPosition(String nameLabel, double xPosition, double yPosition){
        Label position = new Label(nameLabel);
        position.setTranslateX(xPosition);
        position.setTranslateY(yPosition);
        return position;
    }

    private void createDefaultPlayer(){
        Player player = new Player("Name", Color.ALICEBLUE, new ArrayList<Skill>(), "", 0);
        playerList.add(player);

    }
}
