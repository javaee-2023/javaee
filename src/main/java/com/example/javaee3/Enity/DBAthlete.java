package com.example.javaee3.Enity;

public class DBAthlete {
    /**
     * aid 运动员号码（即id）
     * name 运动员名字
     * group 运动员班级
     * sportsTeam 运动员是否为运动队队员
     */
    private int aid;
    private String name;
    private String group;
    private String sportsTeam;

    @Override
    public String toString() {
        return "DBAthlete{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", sportsTeam='" + sportsTeam + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public String getSportsTeam() {
        return sportsTeam;
    }

    public void setSportsTeam(String sportsTeam) {
        this.sportsTeam = sportsTeam;
    }

}
