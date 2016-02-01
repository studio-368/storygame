package edu.bsu.storygame;


import java.awt.*;
import javafx.scene.paint.Color;
import java.util.List;

public class Player {

    String name;
    Color playerColor;
    List skills;
    Point position;
    int totalPoints;

    public Player(String name, Color playerColor, List skills, Point position, int totalPoints){
        this.name = name;
        this.playerColor = playerColor;
        this.skills = skills;
        this.position = position;
        this.totalPoints = totalPoints;
    }

    public String getName(){
        return name;
    }

    public Point getPosition() {
        return position;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public List getSkills() {
        return skills;
    }

    public void addSkill(String skill){
        skills.add(skill);
    }

    public void removeSkill(String skill){
        skills.remove(skill);
    }
}
