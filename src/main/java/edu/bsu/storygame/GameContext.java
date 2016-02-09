package edu.bsu.storygame;

import com.google.common.collect.ImmutableList;
import react.Value;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public final class GameContext {
    public final Value<Phase> phase = Value.create(null);
    public List<Player> players = new ArrayList<>();
    public final Value<Integer> winningPointTotal = Value.create(10);
    public final Value<Integer> currentPlayer = Value.create(0);

}
