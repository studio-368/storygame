package edu.bsu.storygame;

import edu.bsu.storygame.views.PlayerView;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessicalohse on 2/3/16.
 */
public class PlayerUpdate {

    @Test
    public void testSkillUpdate() {
        Player player = new Player("Jessica", Color.ALICEBLUE, "", 5);
        PlayerView view = new PlayerView(player);
        player.addSkill("resourceful");
        Assert.assertEquals(player.getSkillString(), view.getSkillText());
    }

    @Test
    public void testMultipleSkills(){
        Player player = new Player("Jessica", Color.ALICEBLUE, "", 5);
        PlayerView view = new PlayerView(player);
        player.addSkill("resourceful");player.addSkill("helpful");
        Assert.assertEquals(player.getSkillString(), view.getSkillText());
    }


}
