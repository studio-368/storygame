package edu.bsu.storygame.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class EncounterView extends Stage {
    private final VBox container;
    private final ToggleGroup choiceGroup = new ToggleGroup();
    @FXML private Label regionLabel;
    @FXML private Image monsterImage;
    @FXML private Label monsterName;
    @FXML private VBox choices;

    public EncounterView() {
        super();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EncounterView.fxml"));
        loader.setController(this);
        try {
            loader.setLocation(getClass().getResource("/EncounterView.fxml"));
            container = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setScene(new Scene(container));
    }

    public void setRegion(String region) {
        regionLabel.setText("Encounter in " + region);
    }

    public void setMonsterName(String monster) {
        monsterName.setText("It's " + monster + "!");
    }

    public ToggleButton addChoice(String choice) {
        ToggleButton newChoiceButton = new ToggleButton(choice);
        newChoiceButton.setToggleGroup(choiceGroup);
        choices.getChildren().add(newChoiceButton);
        return newChoiceButton;
    }

    public void onConfirm(ActionEvent actionEvent) {
        this.close();
    }
}
