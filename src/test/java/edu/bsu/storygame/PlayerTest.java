package edu.bsu.storygame;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;


public class PlayerTest {

    @Test
    public void testSetRegion(){
        Player player = new Player("Name", Color.BLUE, "");
        player.setRegion(Regions.Africa);
        Assert.assertEquals(Regions.Africa, player.getRegion());
    }

    @Test
    public void testAddPoints(){
        Player player = new Player("Name", Color.ALICEBLUE, "");
        player.totalPoints.update(player.totalPoints.get() + 2);
        Assert.assertEquals(2, (int)player.totalPoints.get());
    }

    @Test
    public void testRemovePoints(){
        Player player = new Player("Name", Color.ALICEBLUE, "");
        player.totalPoints.update(player.totalPoints.get() + 2);
        player.totalPoints.update(player.totalPoints.get() - 2);
        Assert.assertEquals(0, (int)player.totalPoints.get());
    }
}
