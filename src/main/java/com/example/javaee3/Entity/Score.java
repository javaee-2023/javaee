package com.example.javaee3.Entity;

public class Score {
    private String sport;
    private String round;
    private double result;
    private double score;
    private int rank;

    @Override
    public String toString() {
        return "Score{" +
                "sport='" + sport + '\'' +
                ", round='" + round + '\'' +
                ", result=" + result +
                ", score=" + score +
                ", rank=" + rank +
                '}';
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Score(String sport, String round, double result, double score, int rank) {
        this.sport = sport;
        this.round = round;
        this.result = result;
        this.score = score;
        this.rank = rank;
    }


}
