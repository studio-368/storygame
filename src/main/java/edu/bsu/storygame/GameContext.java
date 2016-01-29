package edu.bsu.storygame;

import react.Value;

public final class GameContext {
    public final Value<Phase> phase = Value.create(Phase.MOVEMENT);
}
