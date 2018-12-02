package com.example.yonathan.proyecto.model;

public class NameScoreend {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public NameScoreend(String name, String score) {
        this.name = name;
        this.score = score;
    }

    String name,score;

    public NameScoreend(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    String uid;
    public NameScoreend(){

    }
}
