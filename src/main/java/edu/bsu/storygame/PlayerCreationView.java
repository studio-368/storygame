package edu.bsu.storygame;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreationView {

    GameContext gameContext;
    Button createButton = initButtonPosition("Create", 0, 100);
    TextField characterNameInput = new TextField();
    List<Player> playerList;
    StackPane layout;

    PlayerCreationView(GameContext gameContext){
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
            }
        });
    }

    private Button initButtonPosition(String buttonName, double xPosition, double yPosition){
        Button position = new Button(buttonName);
        position.setTranslateX(xPosition);
        position.setTranslateY(yPosition);
        return position;
    }

    private void createDefaultPlayer(){
        Player player = new Player("Name", Color.ALICEBLUE, "");
        playerList.add(player);

    }
}
