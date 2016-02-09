package edu.bsu.storygame;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Encounter {

    public static class Builder {
        private String monsterName;
        private String narrative;
        private Regions region;
        private List<Reaction> reactions = new ArrayList<>();
        private Image monsterImage;

        public Builder setMonsterName(String monsterName) {
            this.monsterName = monsterName;
            return this;
        }

        public Builder setNarrative(String narrative) {
            this.narrative = narrative;
            return this;
        }

        public Builder setRegion(Regions region) {
            this.region = region;
            return this;
        }

        public Builder setReactions(List<Reaction> reactions) {
            this.reactions = reactions;
            return this;
        }

        public Builder addReaction(Reaction reaction) {
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

    public final String monsterName;
    public final String narrative;
    public final Regions region;
    public final Reaction[] reactions;
    public final Image monsterImage;

    private Encounter(Builder builder) {
        monsterName = builder.monsterName;
        narrative = builder.narrative;
        region = builder.region;
        reactions = new Reaction[builder.reactions.size()];
        builder.reactions.toArray(reactions);
        monsterImage = builder.monsterImage;
    }
}
