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
import react.RList;
import react.Slot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    public PlayerView(final Player player) {
        playerBox.setFill(Paint.valueOf(player.getPlayerColor().toString()));
        name = new Text(0, 0, player.getName());
        StackPane.setAlignment(name, Pos.CENTER_LEFT);
        StackPane.setMargin(name, new Insets(0, 0, 10, 10));
        skills = new Text(10, 10, getSkillString(player.skills));
        StackPane.setAlignment(skills, Pos.BOTTOM_LEFT);
        StackPane.setMargin(skills, new Insets(10, 10, 10, 10));
        diamond.getTransforms().add(new Rotate(45));
        diamond.setFill(null);
        diamond.setStroke(Color.BLACK);
        StackPane.setAlignment(diamond, Pos.CENTER_RIGHT);
        StackPane.setMargin(diamond, new Insets(0, -10, 20, 0));
        points = new Text(Integer.toString(player.totalPoints.get()));
        StackPane.setAlignment(points, Pos.CENTER_RIGHT);
        StackPane.setMargin(points, new Insets(0, 25, 0, 0));
        pane.getChildren().addAll(playerBox, name, skills, diamond, points);
        this.getChildren().add(0, pane);

        player.skills.connect(new RList.Listener<String>() {
            @Override
            public void onAdd(String elem) {
                if(getSkillText().equals("")){
                    skills.setText(elem);
                } else {
                    skills.setText(getSkillText() + ", " + elem);
                }
                super.onAdd(elem);
            }

            @Override
            public void onRemove(String elem) {
                if(getSkillText().equals(elem)){
                    skills.setText("");
                } else {
                    String[] skillsArray = getSkillText().split(", ");
                    if(skillsArray[0].equals(elem)) {
                        skills.setText(getSkillText().replace(elem + ", ", ""));
                    } else {
                        skills.setText(getSkillText().replace(", " + elem , ""));
                    }
                }
                super.onRemove(elem);
            }
        });

        player.totalPoints.connect(new Slot<Integer>() {
            @Override
            public void onEmit(Integer integer) {
                points.setText(Integer.toString(integer));
            }
        });
    }

    public int getPoints(){
        return Integer.parseInt(points.getText());
    }

    public String getSkillText(){
        return this.skills.getText();
    }

    public String getSkillString(RList<String> skills){
        String skillString = "";
        if(skills.size() == 0){
            return skillString;
        } else if(skills.size() == 1){
            return skills.get(0);
        } else {
            for (String skill :
                    skills) {
                skillString = skillString + skill + ", ";
            }
            skillString = skillString.substring(0, skillString.length() - 2);
        }
        return skillString;
    }

}
