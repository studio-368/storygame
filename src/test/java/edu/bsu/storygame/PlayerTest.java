package edu.bsu.storygame;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testSetRegion(){
        Player player = new Player(null,null,null,null,0);
        player.setRegion(Regions.Africa);
        Assert.assertEquals(Regions.Africa, player.getRegion());
    }

    @Test
    public void testSetName(){
        Player player = new Player(null,null,null,null,0);
        player.setName("testName");
        Assert.assertEquals("testName", player.getName());
    }
}
