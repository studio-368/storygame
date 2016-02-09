package edu.bsu.storygame;

import com.google.common.collect.ImmutableList;
import javafx.scene.image.Image;

import java.util.Collection;

public class Encounter {

    public final String monsterName;
    public final String narrative;
    public final Regions region;
    public final ImmutableList<Reaction> reactions;
    public final Image monsterImage;

    public Encounter(String monsterName, String narrative, Regions region, Collection<Reaction> reactions, Image monsterImage) {
        this.monsterName = monsterName;
        this.narrative = narrative;
        this.region = region;
        this.reactions = ImmutableList.copyOf(reactions);
        this.monsterImage = monsterImage;
    }
}
