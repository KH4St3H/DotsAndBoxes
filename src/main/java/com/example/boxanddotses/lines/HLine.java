package com.example.boxanddotses.lines;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class HLine extends BaseLine{
    public HLine(double startX, double startY, double length){
        super(startX, startY, length);
        this.setEndX(startX+length);
    }

}
