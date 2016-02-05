package edu.bsu.storygame;

import javafx.scene.paint.Color;
import react.RList;
import react.Value;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final Color playerColor;
    public final RList<Skill> skills = new RList<>(new ArrayList<Skill>(){});
    public final Value<Integer> totalPoints = Value.create(0);
    private Regions region = Regions.Europe;

    public Player(String name, Color playerColor) {
        this.name = name;
        this.playerColor = playerColor;
        this.region = Regions.Europe;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Regions getRegion() {
        return this.region;
    }

    public String getName() {
        return name;
    }

    public Color getPlayerColor() {
        return playerColor;
    }
}
