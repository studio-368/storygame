package edu.bsu.storygame.views;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import edu.bsu.storygame.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Stack;

/**
 * Created by jessicalohse on 1/29/16.
 */
public class PlayerView extends VBox {

    Player player;
    Rectangle playerBox = new Rectangle(200, 100);

    public PlayerView(Player player) {
        this.player = player;
        String color = player.getPlayerColor().toString();
        playerBox.setFill(Paint.valueOf(color));
        StackPane pane = new StackPane();
        Text name = new Text(0, 0, player.getName());
        StackPane.setAlignment(name, Pos.CENTER_LEFT);
        StackPane.setMargin(name, new Insets(0,0,10,10));
        Text skills = new Text( 10, 10, player.getSkillString());
        StackPane.setAlignment(skills, Pos.BOTTOM_LEFT);
        StackPane.setMargin(skills, new Insets(10, 10, 20, 10));
        pane.getChildren().addAll(playerBox, name, skills);
        this.getChildren().add(0, pane);
    }

    public VBox getView(){
        return this;
    }

}
