package com.example.javaee3.Enity;

public class DBScore {
    /**
     * sid 比赛id
     * score 比赛得分
     * result 比赛结果
     * rank 比赛排名
     * team 比赛队伍
     * number 队伍编号
     */
    private int sid;
    private double score;
    private double result;
    private int rank;
    private String team;
    private String number;

    @Override
    public String toString() {
        return "DBScore{" +
                "sid=" + sid +
                ", score=" + score +
                ", result=" + result +
                ", rank=" + rank +
                ", team='" + team + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
