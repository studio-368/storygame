package edu.bsu.storygame.views;

import edu.bsu.storygame.Player;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by jessicalohse on 1/29/16.
 */
public class PlayerView {

    Player player;
    Rectangle playerBox = new Rectangle(200, 100);

    public PlayerView(Player player) {
        this.player = player;
        String color = player.getPlayerColor().toString();
        playerBox.setFill(Paint.valueOf(color));
    }
}
