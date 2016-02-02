package edu.bsu.storygame.views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SkillSelectionView extends Application {

    private GridPane skillGrid;
    private Scene skillScreen;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setupWindow();
        setupWindowItems();
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
        skillGrid.setStyle("-fx-background-color: aliceblue");
    }

    private void setupWindowItems(){
        Label firstList = new Label("Skill One:");
        firstList.setId("firstList");
        Label secondList = new Label("Skill Two:");
        secondList.setId("secondList");
        ObservableList<String> listOfSkills = FXCollections.observableArrayList("Logic", "Magic", "Persuasion",
                "Weapon Use");
        ComboBox<String> skillOneDropDown = new ComboBox<String>(listOfSkills);
        ComboBox<String> skillTwoDropDown = new ComboBox<String>(listOfSkills);
        Button ok = new Button("OK");
        ok.setAlignment(Pos.BOTTOM_CENTER);
        skillGrid.add(firstList,0,2,2,1);
        skillGrid.add(secondList,4,2,2,1);
        skillGrid.add(skillOneDropDown,0,3,2,1);
        skillGrid.add(skillTwoDropDown,4,3,2,1);
        skillGrid.add(ok,2,4,2,1);
    }

}
