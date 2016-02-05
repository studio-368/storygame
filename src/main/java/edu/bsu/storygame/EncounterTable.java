package edu.bsu.storygame;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class EncounterTable {

    public Encounter createEncounter(GameContext context) {
        ArrayList<String> reactions = new ArrayList<>();
        reactions.add("Run");
        reactions.add("Converse");
        reactions.add("Question");
        reactions.add("Attack");
        return Encounter.builder()
                .setMonsterName("a wraith")
                .setRegion(context.getCurrentPlayer().getRegion().toString())
                .setReactions(reactions)
                .setMonsterImage(new Image("wraith_temp.jpg"))
                .build();
    }


}
