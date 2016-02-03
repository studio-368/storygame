package edu.bsu.storygame;

import edu.bsu.storygame.views.PlayerView;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by jessicalohse on 2/3/16.
 */
public class PlayerUpdate {

    Player player = new Player("Jessica", Color.ALICEBLUE, "");
    PlayerView view = new PlayerView(player);

    @Test
    public void testSkillUpdate() {
        player.addSkill("resourceful");
        Assert.assertEquals(player.getSkillString(), view.getSkillText());
    }

    @Test
    public void testMultipleSkills(){
        player.addSkill("resourceful");
        player.addSkill("helpful");
        Assert.assertEquals(player.getSkillString(), view.getSkillText());
    }

    @Test
    public void testRemoveFirstSkill(){
        player.addSkill("resourceful");
        player.addSkill("helpful");
        player.removeSkill("resourceful");
        Assert.assertEquals(player.getSkillString(), view.getSkillText());
    }

    @Test
    public void testRemoveMiddleSkill(){
        Player player = new Player("Jessica", Color.ALICEBLUE, "");
        PlayerView view = new PlayerView(player);
        player.addSkill("resourceful");
        player.addSkill("wisdom");
        player.addSkill("helpful");
        player.removeSkill("wisdom");
        Assert.assertEquals(player.getSkillString(), view.getSkillText());
    }

    @Test
    public void testAddPoint(){
        player.addPoint(1);
        Assert.assertEquals(player.getTotalPoints(), view.getPoints());
    }

}
