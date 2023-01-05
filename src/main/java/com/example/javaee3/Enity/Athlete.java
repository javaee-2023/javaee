package com.example.javaee3.Enity;

public class Athlete {
    private String id;
    private String name;
    private String group;
    private String sport;
    private String team;
    private String number;
    private String sportsTeam;

    @Override
    public String toString() {
        return "Athlete{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", sport='" + sport + '\'' +
                ", team='" + team + '\'' +
                ", number='" + number + '\'' +
                ", sportsTeam='" + sportsTeam + '\'' +
                '}';
    }

    public Athlete(String id, String name, String group, String sport, String team, String number, String sportsTeam) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.sport = sport;
        this.team = team;
        this.number = number;
        this.sportsTeam = sportsTeam;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSportsTeam() {
        return sportsTeam;
    }

    public void setSportsTeam(String sportsTeam) {
        this.sportsTeam = sportsTeam;
    }
}
