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
        player.skills.add("resourceful");
        Assert.assertEquals(view.getSkillString(player.skills), view.getSkillText());
    }

    @Test
    public void testMultipleSkills(){
        player.skills.add("resourceful");
        player.skills.add("helpful");
        Assert.assertEquals(view.getSkillString(player.skills), view.getSkillText());
    }

    @Test
    public void testRemoveFirstSkill(){
        player.skills.add("resourceful");
        player.skills.add("helpful");
        player.skills.remove("resourceful");
        Assert.assertEquals(view.getSkillString(player.skills), view.getSkillText());
    }

    @Test
    public void testRemoveMiddleSkill(){
        Player player = new Player("Jessica", Color.ALICEBLUE, "");
        PlayerView view = new PlayerView(player);
        player.skills.add("resourceful");
        player.skills.add("wisdom");
        player.skills.add("helpful");
        player.skills.remove("wisdom");
        Assert.assertEquals(view.getSkillString(player.skills), view.getSkillText());
    }

    @Test
    public void testAddPoint(){
        player.totalPoints.update(player.totalPoints.get() + 1);
        Assert.assertEquals((int)player.totalPoints.get(), view.getPoints());
    }

}
