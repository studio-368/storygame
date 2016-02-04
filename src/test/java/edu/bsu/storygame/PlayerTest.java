package edu.bsu.storygame;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void testSetRegion(){
        Player player = new Player("Name", Color.BLUE, new ArrayList<String>(), "", 0);
        player.setRegion(Regions.Africa);
        Assert.assertEquals(Regions.Africa, player.getRegion());
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
