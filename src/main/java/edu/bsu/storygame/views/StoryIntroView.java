package edu.bsu.storygame.views;

import edu.bsu.storygame.Skill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class StoryIntroView extends VBox {

    @FXML
    private Text storyText;
    @FXML
    private HBox skillChoices;

    public StoryIntroView() {
        super();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StoryIntroView.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        populate();
    }

    private void populate() {
        storyText.setText("A THING HAPPENED");
        skillChoices.getChildren().add(new SkillChoiceButton());
        skillChoices.getChildren().add(new SkillChoiceButton(Skill.WEAPON_USE));
    }

    public void onSelect(ActionEvent event) {
        // Change phase?
    }

    private final class SkillChoiceButton extends Button {
        public SkillChoiceButton(Skill skill) {
            super(skill.toString());
            setOnAction(StoryIntroView.this::onSelect);
        }

        public SkillChoiceButton() {
            super("No skill");
            setOnAction(StoryIntroView.this::onSelect);
        }
    }

}
