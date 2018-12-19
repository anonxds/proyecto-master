package com.example.yonathan.proyecto.Blitz.model;

public class NameScoreend {

    public String toString(){
        String info = name + " " + score;
        return info;
    }

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



    String name,score;


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
