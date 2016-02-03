package edu.bsu.storygame;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void testSetRegion(){
        Player player = new Player("Name", Color.BLUE, new ArrayList<>(), "", 0);
        player.setRegion("New Africa");
        Assert.assertEquals("New Africa", player.getRegion());
    }

    @Test
    public void testGetSkillString_SizeOne(){
        ArrayList<Skill> skillList = new ArrayList<>();
        Player player = new Player("Maleficent", Color.GREEN,skillList,"",0);
        player.addSkill(Skill.LOGIC);
        Assert.assertEquals("LOGIC", player.getSkillString());
    }

    @Test
    public void testGetSkillString_SizeTwo(){
        ArrayList<Skill> skillList = new ArrayList<>();
        Player player = new Player("Kermit", Color.GREEN,skillList,"",0);
        player.addSkill(Skill.MAGIC);
        player.addSkill(Skill.PERSUASION);
        Assert.assertEquals("MAGIC, PERSUASION", player.getSkillString());
    }

    @Test
    public void testAddPoints(){
        Player player = new Player(null,null,null,null,0);
        player.addPoints(2);
        Assert.assertEquals(2, player.getTotalPoints());
    }

    @Test
    public void testRemovePoints(){
        Player player = new Player(null,null,null,null,2);
        player.removePoints(2);
        Assert.assertEquals(0, player.getTotalPoints());
    }
}
