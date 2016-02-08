package edu.bsu.storygame.views;

import edu.bsu.storygame.Player;
import edu.bsu.storygame.Skill;
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
        StackPane.setAlignment(playerBox, Pos.BOTTOM_LEFT);
        name = new Text(0, 0, player.getName());
        StackPane.setAlignment(name, Pos.CENTER_LEFT);
        StackPane.setMargin(name, new Insets(0, 0, 10, 10));
        skills = new Text(10, 10, getSkillString(player.skills));
        StackPane.setAlignment(skills, Pos.BOTTOM_LEFT);
        StackPane.setMargin(skills, new Insets(10, 10, 10, 10));
        diamond.getTransforms().add(new Rotate(45));
        diamond.setFill(null);
        diamond.setStroke(Color.BLACK);
        StackPane.setAlignment(diamond, Pos.CENTER_LEFT);
        StackPane.setMargin(diamond, new Insets(0, 0, 20, 160));
        points = new Text(Integer.toString(player.totalPoints.get()));
        StackPane.setAlignment(points, Pos.CENTER_LEFT);
        StackPane.setMargin(points, new Insets(0, 0, 0, 160));
        pane.getChildren().addAll(playerBox, name, skills, diamond, points);
        this.getChildren().add(0, pane);


        player.skills.connect(new RList.Listener<Skill>() {
            @Override
            public void onAdd(Skill elem) {
                if(getSkillText().equals("")){
                    skills.setText(elem.toString());
                } else {
                    skills.setText(getSkillText() + ", " + elem.toString());
                }
                super.onAdd(elem);
            }

            @Override
            public void onRemove(Skill elem) {
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

    public String getSkillString(RList<Skill> skills){
        String skillString = "";
        if(skills.size() == 0){
            return skillString;
        } else if(skills.size() == 1){
            return skills.get(0).toString();
        } else {
            for (Skill skill :
                    skills) {
                skillString = skillString + skill.toString() + ", ";
            }
            skillString = skillString.substring(0, skillString.length() - 2);
        }
        return skillString;
    }

}
