package com.example.javaee3.Entity;

public class Competition {
    String round;
    String sport;
    String team;

    public Competition(String round, String sport, String team) {
        this.round = round;
        this.sport = sport;
        this.team = team;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
