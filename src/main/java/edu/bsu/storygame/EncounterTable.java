package edu.bsu.storygame;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class EncounterTable {

    public Encounter wraithEncounter(GameContext context) {
        ArrayList<String> reactions = new ArrayList<>();
        reactions.add("Run");
        reactions.add("Converse");
        reactions.add("Question");
        reactions.add("Attack");
        return Encounter.builder()
                .setMonsterName("Wraith")
                .setRegion(Regions.Africa)
                .setReactions(reactions)
                .setMonsterImage(new Image("Wraith.jpg"))
                .build();
    }

    public Encounter cockatriceEncounter(GameContext context){
        ArrayList<String> reactions = new ArrayList<>();
        reactions.add("Hug");
        reactions.add("Converse");
        reactions.add("Show it's Reflection");
        reactions.add("Attack");
        return Encounter.builder()
                .setMonsterName("Cockatrice")
                .setRegion(Regions.Europe)
                .setReactions(reactions)
                .setMonsterImage(new Image("Cockatrice.jpg"))
                .build();
    }



}
