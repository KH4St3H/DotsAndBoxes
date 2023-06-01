package com.example.boxanddotses;

import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;

public class Player {
    private static int latestId;
    int id;
    Color color;
    String name;
    private IntegerProperty score;
    public Player(int id, String name, Color color){
        this.id = id;
        this.name = name;
        this.color = color;
    }
    public void setScoreProperty(IntegerProperty property){
        score = property;
    }
    public static Player create(String name, Color color){
        return new Player(latestId++, name, color);
    }

    public void increaseScore(){
//        score.add(1);
        score.setValue(score.getValue()+1);
    }

}
