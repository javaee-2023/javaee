package com.example.javaee3.Entity;

import java.util.List;

public class SportsTeamPlayer {
    private int id;
    private String name;
    List<Score> scoreList;

    public SportsTeamPlayer(int id, String name, List<Score> scoreList) {
        this.id = id;
        this.name = name;
        this.scoreList = scoreList;
    }

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

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
