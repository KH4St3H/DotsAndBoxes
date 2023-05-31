package com.example.boxanddotses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class HLine extends Line{
    public HLine(double startX, double startY, double length){
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(startX+length);
        this.setEndY(startY);
        this.setStrokeWidth(6);
        Color c = Color.rgb(0, 0, 0, 0.1);
        this.setStroke(c);
    }

}
