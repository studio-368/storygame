package edu.bsu.storygame;

import com.google.common.collect.ImmutableList;
import javafx.scene.image.Image;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class EncounterTest {

    private static final Image IMAGE_TEST = mock(Image.class);
    private static final Encounter ENCOUNTER_TEST = new Encounter(
            "a wraith",
            "You've encountered a wraith!",
            Regions.Europe,
            ImmutableList.of(
                    new Reaction("Run"),
                    new Reaction("Converse"),
                    new Reaction("Question"),
                    new Reaction("Attack")
            ),
            IMAGE_TEST
    );


    @Test
    public void testEncounterNameIsWraith() {
        assertEquals("a wraith", ENCOUNTER_TEST.monsterName);
    }

    @Test
    public void testEncounterNarrativeIsWraith() {
        assertEquals("You've encountered a wraith!", ENCOUNTER_TEST.narrative);
    }

    @Test
    public void testEncounterMonsterImageIsWraithTemp() {
        assertEquals(IMAGE_TEST, ENCOUNTER_TEST.monsterImage);
    }

    @Test
    public void testEncounterRegionIsEurope() {
        assertEquals(Regions.Europe, ENCOUNTER_TEST.region);
    }

    @Test
    public void testEncounterReactionsAreInOrder() {
        String[] expectedReactions = {"Run", "Converse", "Question", "Attack"};
        List<Reaction> testReactions = ENCOUNTER_TEST.reactions;
        for (int i = 0; i < testReactions.size(); i++) {
            assertEquals(expectedReactions[i], testReactions.get(i).name);
        }
    }
}
