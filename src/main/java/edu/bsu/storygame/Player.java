package edu.bsu.storygame;

import javafx.scene.paint.Color;
import react.RList;
import react.Value;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private String name;
    private Color playerColor;
    public final RList<String> skills = new RList<String>(new ArrayList<String>(){});
    private String position;
    public int totalPoints;
    private Regions region = Regions.Europe;


    public Player(String name, Color playerColor, String position, int totalPoints) {
        this.name = name;
        this.playerColor = playerColor;
        this.region = Regions.Europe;
        this.totalPoints = totalPoints;
        this.position = position;

    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public Regions getRegion() {
        return this.region;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public List<String> getSkills() {
        return skills;
    }
    
    public String getSkillString(){
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

    public void addSkill(String skill) {
        skills.add(skill);

    }

    public void removeSkill(String skill) {
        if(skills.size() == 0 ){
            System.out.println("you cannot remove a skill");
        } else {
            skills.remove(skill);
        }
    }
}
