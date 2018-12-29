package com.example.yonathan.proyecto.StoryMode;

public class ModelSt {

    public String getParrafo() {
        return parrafo;
    }

    public void setParrafo(String parrafo) {
        this.parrafo = parrafo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelSt(String parrafo, int id) {
        this.parrafo = parrafo;
        this.id = id;
    }

    String parrafo;

    private int id;
}
