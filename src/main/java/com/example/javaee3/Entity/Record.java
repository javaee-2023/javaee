package com.example.javaee3.Entity;

public class Record {
    int id;
    int rank;
    String name;
    double result;
    double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                ", result=" + result +
                '}';
    }

    public Record() {
    }

    public Record(int rank, Record o) {
        this.id=o.getId();
        this.name=o.getName();
        this.result=o.getResult();
        this.score=o.getScore();
        this.rank = rank;
    }

    public Record(int id, int rank, String name, double result) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
