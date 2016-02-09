package edu.bsu.storygame;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SkillTriggerTest {
    private static final SkillTrigger SKILL_TRIGGER_WITH_SKILL = new SkillTrigger(Skill.LOGIC, "You have logic, so good things happen.");
    private static final SkillTrigger SKILL_TRIGGER_WITH_NO_SKILL = new SkillTrigger(null, "You have no skill, so nothing happens.");

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
        assertEquals("You have no skill, so nothing happens.", SKILL_TRIGGER_WITH_NO_SKILL.narrative);
    }
}
