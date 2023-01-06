package com.example.javaee3.Entity;

public class Player implements Comparable<Player>{

    private int rank;
    private int id;
    private String name;
    private String group;
    private String number;
    private double result;//成绩
    private double score;//得分
    private int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + rank +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", number='" + number + '\'' +
                ", result=" + result +
                ", score=" + score +
                '}';
    }

    public Player(int rank, int id, String name, String group, String number, double result, double score) {
        this.rank = rank;
        this.id = id;
        this.name = name;
        this.group = group;
        this.number = number;
        this.result = result;
        this.score = score;
    }

    public Player(int rank, int id, double result, double score) {
        this.rank=rank;
        this.id = id;
        this.result = result;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    @Override
    public int compareTo(Player o) {
        if(o.getResult()==this.result) return this.id-o.getId();
        else {
            return (int)((o.getScore() - this.score)*10000);
        }
    }
}
