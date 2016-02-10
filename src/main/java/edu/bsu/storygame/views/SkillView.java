package edu.bsu.storygame.views;

import edu.bsu.storygame.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SkillView extends BorderPane {

    private final Reaction reaction;
    private final GameContext context;

    @FXML
    private VBox skillButtonContainer;

    public SkillView(Reaction reaction, GameContext context) {
        this.reaction = reaction;
        this.context = context;
        configure();
    }

    private void configure() {
        loadFxml();
        addButtons();
    }

    private void loadFxml() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SkillView.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addButtons() {
        for (SkillTrigger trigger : reaction.skillTriggers) {
            System.out.println(context.currentPlayer.get());
            if(context.players.get(context.currentPlayer.get()).skills.contains(trigger.skill) || trigger.skill ==null) {
                skillButtonContainer.getChildren().add(new SkillTriggerButton(trigger));
            }
        }
    }

    private void onSelection(SkillTriggerButton button) {
        StoryView view = new StoryView(button.skillTrigger, context);
        getScene().setRoot(view);
        context.phase.update(Phase.CONCLUSION);
    }

    private class SkillTriggerButton extends Button {

        public final SkillTrigger skillTrigger;

        private SkillTriggerButton(SkillTrigger trigger) {
            super();
            setText(getSkillText(trigger.skill));
            this.skillTrigger = trigger;
            this.setOnAction(e -> onSelection(SkillTriggerButton.this));
        }

        private String getSkillText(Skill skill) {
            if (skill == null) return "No skill";
            return skill.toString();
        }
    }

}

