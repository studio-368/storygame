package edu.bsu.storygame;


public class Reaction {

    public final String name;

    public Reaction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
