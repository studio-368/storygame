package edu.bsu.storygame;

import javafx.scene.paint.Color;
import java.util.List;

public class Player {

    String name;
    Color playerColor;
    List<Skill> skills;
    String position;
    int totalPoints;
    private String region = "New Europe";


    public Player(String name, Color playerColor, List<Skill> skills, String position, int totalPoints) {
        this.name = name;
        this.playerColor = playerColor;
        this.skills = skills;
        this.region = "Europe";
        this.totalPoints = totalPoints;
        this.position = position;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
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

    public List getSkills() {
        return skills;
    }
    
    public String getSkillString(){
        String skillString = "";
        if(skills.size() == 1){
            return skills.get(0).toString();
        }
        for (Skill skill :
                skills) {
            skillString = skillString + skill.toString() + ", ";
        }
        skillString = skillString.substring(0, skillString.length() - 2);
        return skillString;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }
}
