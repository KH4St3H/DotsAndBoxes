package com.example.boxanddotses;

import com.example.boxanddotses.lines.BaseLine;
import com.example.boxanddotses.lines.HLine;
import com.example.boxanddotses.lines.VLine;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameBoard extends StackPane {
    int dotsCount;
    int boardSize = 800;
    Pane dotsAndLines = new Pane();
    Pane boxes = new Pane();
    Player[] players;
    int turn = 0;
    public GameBoard(int dotsCount, Player[] players){
        this.players = players;

        ObservableList<Node> children = dotsAndLines.getChildren();
        this.setPrefSize(800, 800);

        float gap = (float) (boardSize - 200) / dotsCount;

        this.getChildren().addAll(boxes, dotsAndLines);
        this.dotsCount = dotsCount;
        for (int i = 0; i < dotsCount; i++) {
            for (int j = 0; j < dotsCount; j++) {
                Dot dot = new Dot();
                double X = 100 + (j+0.5) * gap;
                double Y = 100 + gap*(i+0.5);
                dot.setCenterX(X);
                dot.setCenterY(Y);
                if(j < dotsCount - 1){
                    HLine line = new HLine(X, Y, gap);
//                    dotsAndLines.getChildren().add(line);
                    children.add(line);
                    line.setOnMouseClicked(event -> lineClicked(line));
                }
                if(i < dotsCount - 1){
                    VLine line = new VLine(X, Y, gap);
                    children.add(line);
                    line.setOnMouseClicked(event -> lineClicked(line));
                }
                children.add(dot);
            }

        }
    }
    void checkForBoxes(){

    }
    void lineClicked(BaseLine line){
        if(line.isColored()){
           return;
        }
        line.colorize(getPlayingPlayer().color);
        checkForBoxes();
        nextTurn();
    }
    Player getPlayingPlayer(){
        return players[turn];
    }
    void nextTurn(){
        if(++turn == players.length)
            turn = 0;
    }

}
