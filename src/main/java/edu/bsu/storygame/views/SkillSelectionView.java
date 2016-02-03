package edu.bsu.storygame.views;


import edu.bsu.storygame.Player;
import edu.bsu.storygame.Skill;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;



public class SkillSelectionView extends Application {

    private GridPane skillGrid;
    private Scene skillScreen;
    private Button ok;
    private Player player = new Player("draco", Color.GREEN ,new ArrayList<>(),"",60);
    private ComboBox<Skill> skillTwoDropDown;
    private ComboBox<Skill> skillOneDropDown;
    private Label warningLabel;
    private Label listOneLabel;
    private Label listTwoLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setupWindow();
        prepareWindowItems();
        applyStyles();
        addItemsToGrid();
        primaryStage.setScene(skillScreen);
        primaryStage.show();
    }

    private void setupWindow(){
        skillGrid = new GridPane();
        skillGrid.setMinSize(300,300);
        skillGrid.setVgap(15);
        skillGrid.setHgap(10);
        skillGrid.setAlignment(Pos.CENTER);
        skillScreen = new Scene(skillGrid,300,300);

    }

    private void applyStyles(){
        skillGrid.setStyle("-fx-background-color: #F8ECC2; -fx-border-color: #C08826; -fx-border-width: 2.5px; -fx-border-radius: 2px");
        listOneLabel.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
        listTwoLabel.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
        ok.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
    }

    private void prepareWindowItems(){
        listOneLabel = new Label("Skill One:");
        listOneLabel.setId("listOneLabel");
        listTwoLabel = new Label("Skill Two:");
        listTwoLabel.setId("listTwoLabel");
        warningLabel = new Label("Must choose two skills.");
        warningLabel.setVisible(false);
        ObservableList<Skill> listOfSkills = FXCollections.observableArrayList(Skill.LOGIC, Skill.MAGIC, Skill.PERSUASION,
                Skill.WEAPON_USE);
        skillOneDropDown = new ComboBox<>(listOfSkills);
        skillTwoDropDown = new ComboBox<>(listOfSkills);
        skillOneDropDown.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue == null && newValue != null){
                removeValueFrom(skillTwoDropDown,newValue);
            }
        });
        skillTwoDropDown.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue == null && newValue != null){
                removeValueFrom(skillOneDropDown,newValue);
            }
        });
        ok = new Button("OK");
        ok.setOnMouseClicked(e -> handleOkEvent());
        ok.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void removeValueFrom(ComboBox<Skill> comboBox,Skill skill) {
        ObservableList<Skill> changingList  = FXCollections.observableArrayList(Skill.LOGIC, Skill.MAGIC, Skill.PERSUASION,
                Skill.WEAPON_USE);
        changingList.remove(skill);
        comboBox.setItems(changingList);
    }

    private void addItemsToGrid(){
        skillGrid.add(listOneLabel,0,2,2,1);
        skillGrid.add(listTwoLabel,4,2,2,1);
        skillGrid.add(warningLabel,0,6,5,1);
        skillGrid.add(skillOneDropDown,0,3,2,1);
        skillGrid.add(skillTwoDropDown,4,3,2,1);
        skillGrid.add(ok,2,4,2,1);
    }

    private void handleOkEvent(){
        Skill firstChoice = skillOneDropDown.getValue();
        Skill secondChoice= skillTwoDropDown.getValue();
        if(firstChoice!=null&&secondChoice!=null) {
            player.addSkill(firstChoice);
            player.addSkill(secondChoice);
        }
        else {
            warningLabel.setVisible(true);
        }
    }
}
