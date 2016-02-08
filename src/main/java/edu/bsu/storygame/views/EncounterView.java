package edu.bsu.storygame.views;


import edu.bsu.storygame.Encounter;
import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class EncounterView extends VBox {
    @FXML
    private Label regionLabel;
    @FXML
    private ImageView monsterImageView;
    @FXML
    private Label monsterName;
    @FXML
    private VBox choices;
    @FXML
    private Button confirmButton;
    private final Encounter encounter;
    private final ToggleGroup choiceGroup = new ToggleGroup();

    public EncounterView(Encounter encounter) {
        super();
        this.encounter = encounter;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EncounterView.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.setLocation(getClass().getResource("/EncounterView.fxml"));
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        populate();
    }

    private void populate() {
        setRegion();
        setMonsterName();
        setImage();
        addChoices();
    }

    private void setRegion() {
        regionLabel.setText("Encounter in " + encounter.getRegion());
    }

    private void setMonsterName() {
        monsterName.setText("It's " + encounter.getMonsterName() + "!");
    }

    private void setImage() {
        monsterImageView.setImage(encounter.getMonsterImage());
    }

    private void addChoices() {
        ToggleButton newChoiceButton;
        for (String choice : encounter.getReactions()) {
            newChoiceButton = new ChoiceToggleButton(choice);
            choices.getChildren().add(newChoiceButton);
        }
    }

    @FXML
    public void onConfirm(ActionEvent actionEvent) {

    }

    private final class ChoiceToggleButton extends ToggleButton {
        public ChoiceToggleButton(String choice) {
            super(choice);
            setToggleGroup(choiceGroup);
            setOnAction(event -> choose());
        }

        private void choose() {
            boolean isChoiceSelected = choiceGroup.getSelectedToggle() != null;
            confirmButton.setDisable(!isChoiceSelected);
        }
    }
}
