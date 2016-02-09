package edu.bsu.storygame;

import javafx.scene.image.Image;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class EncounterTest {

    private static final Image IMAGE_TEST = mock(Image.class);
    private static final Encounter ENCOUNTER_TEST = Encounter.builder()
            .setMonsterName("a wraith")
            .setNarrative("You've encountered a wraith!")
            .setMonsterImage(IMAGE_TEST)
            .setRegion(Regions.Europe)
            .addReaction(Reaction.builder().setName("Run").build())
            .addReaction(Reaction.builder().setName("Converse").build())
            .addReaction(Reaction.builder().setName("Question").build())
            .addReaction(Reaction.builder().setName("Attack").build())
            .build();

    @Test
    public void testEncounterNameIsWraith() {
        assertEquals("a wraith", ENCOUNTER_TEST.getMonsterName());
    }

    @Test
    public void testEncounterNarrativeIsWraith() {
        assertEquals("You've encountered a wraith!", ENCOUNTER_TEST.getNarrative());
    }

    @Test
    public void testEncounterMonsterImageIsWraithTemp() {
        assertEquals(IMAGE_TEST, ENCOUNTER_TEST.getMonsterImage());
    }

    @Test
    public void testEncounterRegionIsEurope() {
        assertEquals(Regions.Europe, ENCOUNTER_TEST.getRegion());
    }

    @Test
    public void testEncounterReactionsAreInOrder() {
        String[] expectedReactions = {"Run", "Converse", "Question", "Attack"};
        Reaction[] testReactions = ENCOUNTER_TEST.getReactions();
        for (int i = 0; i < testReactions.length; i++) {
            assertEquals(expectedReactions[i], testReactions[i].getName());
        }
    }
}
