package edu.bsu.storygame;

import react.Value;

import java.util.ArrayList;
import java.util.List;

public final class GameContext {

    public final Value<Phase> phase = Value.create(Phase.MOVEMENT);
    public List<Player> players = new ArrayList<>();
    public final Value<Integer> winningPointTotal = Value.create(10);

}
