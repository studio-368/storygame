package edu.bsu.storygame;

import javafx.scene.image.Image;

public class Encounter {

    public final String monsterName;
    public final String narrative;
    public final Regions region;
    public final Reaction[] reactions;
    public final Image monsterImage;

    public Encounter(String monsterName, String narrative, Regions region, Reaction[] reactions, Image monsterImage) {
        this.monsterName = monsterName;
        this.narrative = narrative;
        this.region = region;
        this.reactions = reactions;
        this.monsterImage = monsterImage;
    }
}
