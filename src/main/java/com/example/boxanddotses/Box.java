package com.example.boxanddotses;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box extends Rectangle {
    public Box(int X, int Y, int side, Color color){
        this.setX(X);
        this.setY(Y);
        this.setWidth(side);
        this.setHeight(side);
        this.setFill(color);
    }

}
