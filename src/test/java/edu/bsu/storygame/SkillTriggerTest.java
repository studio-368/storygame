package edu.bsu.storygame;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class SkillTriggerTest {

    private static final Result RESULT_TEST = mock(Result.class);
    private static final SkillTrigger SKILL_TRIGGER_WITH_SKILL = new SkillTrigger(Skill.LOGIC, "You have logic, so good things happen.", RESULT_TEST);
    private static final SkillTrigger SKILL_TRIGGER_WITH_NO_SKILL = new SkillTrigger(null, "You have no skill, so noResult happens.", RESULT_TEST);

    @Test
    public void testSkillTriggerReturnsLogic() {
        assertEquals(Skill.LOGIC, SKILL_TRIGGER_WITH_SKILL.skill);
    }

    @Test
    public void testSkillTriggerReturnsNoSkill() {
        assertNull(SKILL_TRIGGER_WITH_NO_SKILL.skill);
    }

    @Test
    public void testTriggerReturnsLogicNarrative() {
        assertEquals("You have logic, so good things happen.", SKILL_TRIGGER_WITH_SKILL.narrative);
    }

    @Test
    public void testTriggerReturnsBasicNarrative() {
        assertEquals("You have no skill, so noResult happens.", SKILL_TRIGGER_WITH_NO_SKILL.narrative);
    }

    @Test
    public void testTriggerReturnsResult() {
        assertEquals(RESULT_TEST, SKILL_TRIGGER_WITH_SKILL.result);
    }
}
