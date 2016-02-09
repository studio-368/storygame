package edu.bsu.storygame;


public class Reaction {


    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Reaction build() {
            return new Reaction(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private final String name;

    private Reaction(Builder builder) {
        name = builder.name;
    }

    public String getName() {
        return name;
    }
}
