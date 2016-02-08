package edu.bsu.storygame;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class EncounterTable {

    private final GameContext context;

    public EncounterTable(GameContext context) {
        this.context = context;
    }

    public Encounter createEncounter() {
        if (currentRegionIsWest()) {
            return westEncounter();
        }
        return eastEncounter();
    }

    private boolean currentRegionIsWest() {
        return context.players.get(0).getRegion() == Regions.Europe;
    }

    private Encounter westEncounter() {
        return wraithEncounter();
    }

    private Encounter eastEncounter() {
        return cockatriceEncounter();
    }

    public Encounter wraithEncounter() {
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

    public Encounter cockatriceEncounter() {
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
