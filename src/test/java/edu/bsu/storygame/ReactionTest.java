package edu.bsu.storygame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReactionTest {

    private static final Reaction REACTION_TEST = Reaction.builder()
            .setName("Attack")
            .build();

    @Test
    public void testReactionIsAttack() {
        assertEquals("Attack", REACTION_TEST.getName());
    }

}
