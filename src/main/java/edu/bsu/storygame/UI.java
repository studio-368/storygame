package edu.bsu.storygame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class UI extends Application implements EventHandler {

    Button createButton;
    TextField characterNameInput;
    GridPane grid;
    Scene scene;
    HBox HBoxButton;
    List<Player> playerList;
    List<String> placeholderSkillList;
    Point placeholderPoint;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        startGridPane();
        initializeUIVariables();
        initializePlayerCreationVariables();
        startInterfaceActivity(primaryStage);
    }

    public void handle(javafx.event.Event event) {
        if(event.getSource() == createButton){
            if(checkForValidNameInput(characterNameInput.getText())){
                createDefaultPlayer();
            } else {
                //Do Nothing
            }
        }
    }

    private void startInterfaceActivity(Stage primaryStage){
        primaryStage.setTitle("Name your character");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createDefaultPlayer(){
        /*Player player = new Player(characterNameInput.getText(), Color.BLUE, placeholderSkillList, placeholderPoint, 0);*/
        Player player = new Player();
        playerList.add(player);
    }

    private void initializePlayerCreationVariables(){
        playerList = new ArrayList<Player>();
        placeholderSkillList = new ArrayList<String>();
        placeholderSkillList.add("Flexibility");
        placeholderSkillList.add("Second Skill");
        placeholderPoint = new Point(0,0);
    }

    private void startGridPane(){

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
    }

    private void initializeUIVariables(){

        scene = new Scene(grid, 300, 250);
        createButton = new Button("Create");
        createButton.setOnAction(this);
        HBoxButton = new HBox(10);
        HBoxButton.setAlignment(Pos.BOTTOM_CENTER);
        HBoxButton.getChildren().add(createButton);
        grid.add(HBoxButton, 1, 4);
        characterNameInput = new TextField();
        grid.add(characterNameInput, 1, 1);
    }

    private boolean checkForValidNameInput(String name){
        if(name.equals("")){
            return false;
        }
        else{
            return true;
        }
    }

}
