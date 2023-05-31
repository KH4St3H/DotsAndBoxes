package com.example.boxanddotses.lines;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class VLine extends BaseLine {
    public VLine(double startX, double startY, double length) {
        super(startX, startY, length);
        this.setEndY(startY + length);
    }
}
