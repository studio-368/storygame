package edu.bsu.storygame.views;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import edu.bsu.storygame.Player;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by jessicalohse on 1/29/16.
 */
public class PlayerView extends VBox {

    Player player;
    Rectangle playerBox = new Rectangle(200, 100);
    VBox vbox = new VBox();

    public PlayerView(Player player) {
        this.player = player;
        String color = player.getPlayerColor().toString();
        System.out.print(color);
        playerBox.setFill(Paint.valueOf(color));
        vbox.getChildren().add(0, playerBox);
    }

    public VBox getView(){
        return vbox;
    }

}
