package edu.bsu.storygame;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testSetRegion(){
        Player player = new Player();
        player.setRegion("Africa");
        Assert.assertEquals("Africa", player.getRegion());
    }
}
