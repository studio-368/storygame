package edu.bsu.storygame.views;

import edu.bsu.storygame.GameContext;
import edu.bsu.storygame.Phase;
import edu.bsu.storygame.SkillTrigger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class StoryView extends VBox {

    private final SkillTrigger skillTrigger;
    private final GameContext context;

    @FXML
    private Text storyText;
    @FXML
    private Text resultText;
    @FXML
    private Button confirmButton;

    public StoryView(SkillTrigger skillTrigger, GameContext context) {
        this.skillTrigger = skillTrigger;
        this.context = context;
        configure();
    }

    private void configure() {
        loadFxml();
        storyText.setText(skillTrigger.narrative);
        processResultText();
    }

    private void loadFxml() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StoryView.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processResultText() {
        final int storyPointsDelta = skillTrigger.result.storyPointsDelta;
        if (storyPointsDelta < 0)
            resultText.setText("-" + storyPointsDelta + " story points");
        else if (storyPointsDelta > 0)
            resultText.setText("+" + storyPointsDelta + " story points");
        else
            resultText.setText("No effect");
    }

    @FXML
    private void onConfirm() {
        skillTrigger.result.doResult(context);
        if(context.currentPlayer.get() < context.players.size() - 1){
            context.currentPlayer.update(context.currentPlayer.get() + 1);
        } else {
            context.currentPlayer.update(0);
        }
        context.phase.update(Phase.MOVEMENT);
    }
}
