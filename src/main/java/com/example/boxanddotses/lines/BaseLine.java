package com.example.boxanddotses.lines;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class BaseLine extends Line {
    boolean colored = false;
    public BaseLine(double startX, double startY, double length){
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(startX);
        this.setEndY(startY);
        this.setStrokeWidth(6);
        Color defaultColor = Color.rgb(0, 0, 0, 0.1);
        Color hoveredColor = Color.rgb(0, 0, 0, 0.5);
        this.setStroke(defaultColor);
        this.setOnMouseEntered(mouseEvent -> {
            if(this.getStroke() == defaultColor && !colored)
                this.setStroke(hoveredColor);
        });

        this.setOnMouseExited(mouseEvent -> {
            if(this.getStroke() == hoveredColor && !colored)
                this.setStroke(defaultColor);
        });
    }
    public boolean isColored(){
        return colored;
    }
    public void colorize(Color color){
        colored = true;
        this.setStroke(color);
    }
}
