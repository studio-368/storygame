package edu.bsu.storygame;

import javafx.scene.paint.Color;
import react.Value;

import java.util.ArrayList;

public final class GameContext {
    public final Value<Phase> phase = Value.create(Phase.MOVEMENT);
    public final Player player1 = new Player("Name", Color.BLUE, new ArrayList<String>(), "", 0);

    public Player getCurrentPlayer() {
        return player1;
    }
}
