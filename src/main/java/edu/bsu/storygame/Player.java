package edu.bsu.storygame;

import javafx.scene.paint.Color;
import react.Value;

import java.util.List;

public class Player {


    private String name;
    private Color playerColor;
    public Value<List<String>> skills;
    private String position;
    public int totalPoints;
    private Regions region = Regions.Europe;


    public Player(String name, Color playerColor, List<String> skills, String position, int totalPoints) {
        this.name = name;
        this.playerColor = playerColor;
        this.skills = Value.create(skills);
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
        return skills.get();
    }
    
    public String getSkillString(){
        String skillString = "";
        List<String> skillsList = skills.get();
        if(skillsList.size() == 1){
            return skillsList.get(0);
        }
        for (String skill :
                skillsList) {
            skillString = skillString + skill + ", ";
        }
        skillString = skillString.substring(0, skillString.length() - 2);
        return skillString;
    }

    public void addSkill(String skill) {
        skills.get().add(skill);
        skills.update(skills.get());

    }

    public void removeSkill(String skill) {
        skills.get().remove(skill);
    }
}
