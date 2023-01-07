package com.example.javaee3.Entity;

import java.util.ArrayList;
import java.util.List;

public class SportsTeamPlayer {
    private int id;
    private String name;
    private ArrayList<Score> scoreList;


    @Override
    public String toString() {
        return "SportsTeamPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scoreList=" + scoreList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
