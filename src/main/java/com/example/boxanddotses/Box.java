package com.example.boxanddotses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box extends Rectangle {
    private int activeLineCount = 0;
    private boolean active = false;
    public Box(double X, double Y, double side){
        this.setX(X);
        this.setY(Y);
        this.setWidth(side);
        this.setHeight(side);
        Color color = Color.color(1, 1, 1, 0.);
        this.setFill(color);
    }
    Color diluteColor(Color color){
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 0.3);
    }
    void setColor(Color color){
        this.setFill(diluteColor(color));
    }
    public boolean isActive(){
        return active;
    }
    public boolean addLine(){
        activeLineCount++;
        if(activeLineCount==4)
            active = true;
        return active;
    }

}
