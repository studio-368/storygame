package edu.bsu.storygame;


import com.google.common.collect.ImmutableList;

import java.util.Collection;

public class Reaction {

    public final String name;
    public final ImmutableList<SkillTrigger> skillTriggers;

    public Reaction(String name, Collection<SkillTrigger> skillTriggers) {
        this.name = name;
        this.skillTriggers = ImmutableList.copyOf(skillTriggers);
    }

    @Override
    public String toString() {
        return name;
    }
}
