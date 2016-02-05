package edu.bsu.storygame;

import javafx.scene.paint.Color;
import react.Value;

import java.util.ArrayList;
import java.util.List;


public final class GameContext {
    public final Value<Phase> phase = Value.create(Phase.MOVEMENT);
    public final Player player1 = new Player("Name", Color.BLUE, "");
    public List<Player> players = new ArrayList<>();

    public Player getCurrentPlayer() {
        return player1;
    }
}
