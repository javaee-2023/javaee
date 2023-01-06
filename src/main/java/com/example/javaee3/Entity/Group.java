package com.example.javaee3.Entity;

public class Group implements Comparable<Group>{

    private int rank;
    private String group;
    private double score;

    public Group(int rank, String group, double score) {
        this.rank = rank;
        this.group = group;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Group o) {
        return (int)((o.getScore()-this.score)*100000000);
    }
}
