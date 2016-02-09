package edu.bsu.storygame;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

public class ReactionTest {
    private static final List<SkillTrigger> SKILL_TRIGGERS_TEST = newArrayList(
            new SkillTrigger(Skill.LOGIC, "You have logic, so good things happen.", Result.noResult()),
            new SkillTrigger(null, "You have no skills, so nothing happens.", Result.noResult())
    );
    private static final Reaction REACTION_TEST = new Reaction(
            "Attack",
            SKILL_TRIGGERS_TEST);

    @Test
    public void testReactionIsAttack() {
        assertEquals("Attack", REACTION_TEST.name);
    }

    @Test
    public void skillTriggersAreInOrder() {
        assertEquals(SKILL_TRIGGERS_TEST, REACTION_TEST.skillTriggers);
    }

}
