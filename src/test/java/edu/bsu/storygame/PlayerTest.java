package edu.bsu.storygame;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {

    @Test
    public void testSetRegion(){
        Player player = new Player("Name", Color.BLUE, new ArrayList<String>(), "", 0);
        player.setRegion("New Africa");
        Assert.assertEquals("New Africa", player.getRegion());
    }
}
