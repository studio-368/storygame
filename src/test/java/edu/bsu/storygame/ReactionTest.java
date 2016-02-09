package edu.bsu.storygame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReactionTest {

    private static final Reaction REACTION_TEST = new Reaction("Attack");

    @Test
    public void testReactionIsAttack() {
        assertEquals("Attack", REACTION_TEST.name);
    }

}
