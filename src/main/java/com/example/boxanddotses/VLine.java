package com.example.boxanddotses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class VLine extends Line {
    public VLine(double startX, double startY, double length) {
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(startX);
        this.setEndY(startY + length);
        this.setStrokeWidth(6);
        Color c = Color.rgb(0, 0, 0, 0.1);
        this.setStroke(c);
    }
}
