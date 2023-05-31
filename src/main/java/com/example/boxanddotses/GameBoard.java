package com.example.boxanddotses;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameBoard extends StackPane {
    int dotsCount;
    int boardSize = 800;
    Pane gridPane = new Pane();
    public GameBoard(int dotsCount){
        ObservableList<Node> children = gridPane.getChildren();
        gridPane.setPrefSize(800, 800);
        this.setPrefSize(800, 800);

        float gap = (float) (boardSize - 200) / dotsCount;
        Pane lines = new Pane();

        this.getChildren().addAll(gridPane, lines);
        this.dotsCount = dotsCount;
        for (int i = 0; i < dotsCount; i++) {
            for (int j = 0; j < dotsCount; j++) {
                Dot dot = new Dot();
                children.add(dot);
                double X = 100 + (j+0.5) * gap;
                double Y = 100 + gap*(i+0.5);
                dot.setCenterX(X);
                dot.setCenterY(Y);
                if(j < dotsCount - 1){
                    HLine line = new HLine(X, Y, gap);
                    lines.getChildren().add(line);
                }
                if(i < dotsCount - 1){
                    VLine line = new VLine(X, Y, gap);
                    lines.getChildren().add(line);
                }
            }

        }
    }

}
