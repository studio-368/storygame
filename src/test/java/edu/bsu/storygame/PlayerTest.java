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
}
