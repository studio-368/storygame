package edu.bsu.storygame;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Encounter {

    public static class Builder {
        private String monsterName;
        private Regions region;
        private List<String> reactions = new ArrayList<>();
        private Image monsterImage;

        public Builder setMonsterName(String monsterName) {
            this.monsterName = monsterName;
            return this;
        }

        public Builder setRegion(Regions region) {
            this.region = region;
            return this;
        }

        public Builder setReactions(List<String> reactions) {
            this.reactions = reactions;
            return this;
        }

        public Builder addReaction(String reaction) {
            reactions.add(reaction);
            return this;
        }

        public Builder setMonsterImage(Image monsterImage) {
            this.monsterImage = monsterImage;
            return this;
        }

        public Encounter build() {
            return new Encounter(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private final String monsterName;
    private final Regions region;
    private final String[] reactions;
    private final Image monsterImage;

    private Encounter(Builder builder) {
        monsterName = builder.monsterName;
        region = builder.region;
        reactions = new String[builder.reactions.size()];
        builder.reactions.toArray(reactions);
        monsterImage = builder.monsterImage;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public Regions getRegion() {
        return region;
    }

    public String[] getReactions() {
        return reactions;
    }

    public Image getMonsterImage() {
        return monsterImage;
    }
}
