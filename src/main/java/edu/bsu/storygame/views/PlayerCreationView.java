package edu.bsu.storygame.views;


import edu.bsu.storygame.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import react.Slot;
import react.UnitSignal;

public class PlayerCreationView {

    private GridPane skillGrid;
    private Scene skillScreen;
    private Button ok;
    private ComboBox<Skill> skillTwoDropDown;
    private ComboBox<Skill> skillOneDropDown;
    private Label skillWarningLabel;
    private Label nameWarningLabel;
    private Label listOneLabel;
    private Label listTwoLabel;
    private Label nameLabel;
    private TextField playerName;
    private GameContext context;
    public final UnitSignal onFinish = new UnitSignal();


    public PlayerCreationView(GameContext context) {
        this.context = context;
        context.phase.connect(new Slot<Phase>() {
            @Override
            public void onEmit(Phase phase) {
            }
        });
    }

    public Scene getPlayerCreationScene() {
        setupWindow();
        prepareWindowItems();
        applyStyles();
        addItemsToGrid();
        return skillScreen;
    }

    private void setupWindow() {
        skillGrid = new GridPane();
        skillGrid.setMinSize(300, 300);
        skillGrid.setVgap(15);
        skillGrid.setHgap(10);
        skillGrid.setAlignment(Pos.CENTER);
        skillScreen = new Scene(skillGrid, 300, 300);

    }

    private void applyStyles() {
        skillGrid.setStyle("-fx-background-color: #F8ECC2; -fx-border-color: #C08826; -fx-border-width: 2.5px; -fx-border-radius: 2px");
        listOneLabel.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
        listTwoLabel.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
        nameLabel.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
        ok.setStyle("-fx-font-style: italic; -fx-font-family: Georgia");
    }

    private void prepareWindowItems() {
        nameLabel = new Label("Name: ");
        playerName = new TextField();
        listOneLabel = new Label("Skill One:");
        listOneLabel.setId("listOneLabel");
        listTwoLabel = new Label("Skill Two:");
        listTwoLabel.setId("listTwoLabel");
        skillWarningLabel = new Label("Must choose two skills");
        skillWarningLabel.setVisible(false);
        nameWarningLabel = new Label("Must enter a name");
        nameWarningLabel.setVisible(false);
        ObservableList<Skill> listOfSkills = FXCollections.observableArrayList(Skill.values());
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

    private void removeValueFrom(ComboBox<Skill> comboBox, Skill skill) {
        ObservableList<Skill> changingList  = FXCollections.observableArrayList(Skill.LOGIC, Skill.MAGIC, Skill.PERSUASION,
                Skill.WEAPON_USE);
        changingList.remove(skill);
        comboBox.setItems(changingList);
    }

    private void addItemsToGrid(){
        skillGrid.add(nameLabel, 1,0,2,1);
        skillGrid.add(playerName,4,0,2,1);
        skillGrid.add(listOneLabel,0,2,2,1);
        skillGrid.add(listTwoLabel,4,2,2,1);
        skillGrid.add(skillWarningLabel,0,6,5,1);
        skillGrid.add(nameWarningLabel,0,7,5,1);
        skillGrid.add(skillOneDropDown,0,3,2,1);
        skillGrid.add(skillTwoDropDown,4,3,2,1);
        skillGrid.add(ok,2,4,2,1);
    }

    private void handleOkEvent() {
        Skill firstChoice = skillOneDropDown.getValue();
        Skill secondChoice = skillTwoDropDown.getValue();
        String name = playerName.getText();
        if (firstChoice != null && secondChoice != null && !name.equals("")) {
            Player player;
            if(context.players.size() == 0) {
                player = new Player(name, Color.RED);
            } else {
                player = new Player(name, Color.YELLOW);
                player.setRegion(Regions.Africa);
            }
            player.skills.add(firstChoice);
            player.skills.add(secondChoice);
            context.players.add(player);
            if(context.players.size() == 2) {
                onFinish.emit();
            } else {
                playerName.setText("");
                skillOneDropDown.getSelectionModel().clearSelection();
                skillTwoDropDown.getSelectionModel().clearSelection();
            }
        } else {
            skillWarningLabel.setVisible(true);
            nameWarningLabel.setVisible(true);
        }
    }

}
