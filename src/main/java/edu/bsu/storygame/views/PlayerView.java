package edu.bsu.storygame.views;

import edu.bsu.storygame.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

import javafx.scene.paint.Color;

/**
 * Created by jessicalohse on 1/29/16.
 */
public class PlayerView extends VBox {

    Player player;
    Rectangle playerBox = new Rectangle(200, 75);

    public PlayerView(Player player) {
        this.player = player;
        String color = player.getPlayerColor().toString();
        playerBox.setFill(Paint.valueOf(color));
        StackPane pane = new StackPane();
        Text name = new Text(0, 0, player.getName());
        StackPane.setAlignment(name, Pos.CENTER_LEFT);
        StackPane.setMargin(name, new Insets(0, 0, 10, 10));
        Text skills = new Text(10, 10, player.getSkillString());
        StackPane.setAlignment(skills, Pos.BOTTOM_LEFT);
        StackPane.setMargin(skills, new Insets(10, 10, 10, 10));
        Rectangle diamond = new Rectangle(40, 40);
        diamond.getTransforms().add(new Rotate(45));
        diamond.setFill(null);
        diamond.setStroke(Color.BLACK);
        StackPane.setAlignment(diamond, Pos.CENTER_RIGHT);
        StackPane.setMargin(diamond, new Insets(0, -10, 20, 0));
        Text points = new Text(Integer.toString(player.getTotalPoints()));
        StackPane.setAlignment(points, Pos.CENTER_RIGHT);
        StackPane.setMargin(points, new Insets(0, 25, 0, 0));
        pane.getChildren().addAll(playerBox, name, skills, diamond, points);
        this.getChildren().add(0, pane);
    }

    public VBox getView() {
        return this;
    }

}
