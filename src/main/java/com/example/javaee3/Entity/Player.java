package com.example.javaee3.Entity;

public class Player{

    private int rank;
    private String id;
    private String name;
    private String group;
    private String number;
    private double result;//成绩
    private double score;//得分
    private String sport;

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + rank +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", number='" + number + '\'' +
                ", result=" + result +
                ", score=" + score +
                ", sport='" + sport + '\'' +
                '}';
    }

    public Player(int rank, String id, String name, String group, String number, double result, double score, String sport) {
        this.rank = rank;
        this.id = id;
        this.name = name;
        this.group = group;
        this.number = number;
        this.result = result;
        this.score = score;
        this.sport = sport;
    }



    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
