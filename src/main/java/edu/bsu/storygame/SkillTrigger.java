package edu.bsu.storygame;

public class SkillTrigger {

    public final Skill skill;
    public final String narrative;
    public final Result result;

    public SkillTrigger(Skill skill, String narrative, Result result) {
        this.skill = skill;
        this.narrative = narrative;
        this.result = result;
    }
}
