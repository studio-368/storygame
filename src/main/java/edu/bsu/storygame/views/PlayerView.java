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

    private Rectangle playerBox = new Rectangle(200, 75);
    private Text name;
    private Text skills;
    private Rectangle diamond = new Rectangle(40, 40);
    private Text points;
    private StackPane pane = new StackPane();

    public PlayerView(Player player) {
        playerBox.setFill(Paint.valueOf(player.getPlayerColor().toString()));
        name = new Text(0, 0, player.getName());
        StackPane.setAlignment(name, Pos.CENTER_LEFT);
        StackPane.setMargin(name, new Insets(0, 0, 10, 10));
        skills = new Text(10, 10, player.getSkillString());
        StackPane.setAlignment(skills, Pos.BOTTOM_LEFT);
        StackPane.setMargin(skills, new Insets(10, 10, 10, 10));
        diamond.getTransforms().add(new Rotate(45));
        diamond.setFill(null);
        diamond.setStroke(Color.BLACK);
        StackPane.setAlignment(diamond, Pos.CENTER_RIGHT);
        StackPane.setMargin(diamond, new Insets(0, -10, 20, 0));
        points = new Text(Integer.toString(player.getTotalPoints()));
        StackPane.setAlignment(points, Pos.CENTER_RIGHT);
        StackPane.setMargin(points, new Insets(0, 25, 0, 0));
        pane.getChildren().addAll(playerBox, name, skills, diamond, points);
        this.getChildren().add(0, pane);

        

    }

    public VBox getView() {
        return this;
    }

    public void updateSkills(Player player) {
        skills.setText(player.getSkillString());
    }

    public void updatePoints(Player player){
        points.setText(Integer.toString(player.getTotalPoints()));
    }

}
