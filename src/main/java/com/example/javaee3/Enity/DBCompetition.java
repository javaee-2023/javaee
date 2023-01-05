package com.example.javaee3.Enity;

public class DBCompetition {
    /**
     * cid 比赛id
     * round 比赛轮次
     * sport 比赛项目
     */
    private int cid;
    private String round;
    private String sport;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "DBCompetition{" +
                "cid=" + cid +
                ", round='" + round + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
