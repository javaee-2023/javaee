package com.example.javaee3.Entity;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String group;
    List<Score> scoreList;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", scoreList=" + scoreList +
                '}';
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

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public Student() {
    }

    public Student(int id, String name, String group, List<Score> scoreList) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.scoreList = scoreList;
    }
}
