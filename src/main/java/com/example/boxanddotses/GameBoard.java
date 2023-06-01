package com.example.boxanddotses;

import com.example.boxanddotses.lines.BaseLine;
import com.example.boxanddotses.lines.HLine;
import com.example.boxanddotses.lines.VLine;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameBoard extends StackPane {
    static double gap;
    Pane dotsAndLines = new Pane();
    Pane boxes = new Pane();
    Player[] players;
    int turn = 0;
    public GameBoard(int dotsCount, Player[] players){
        int boardSize = 800;
        this.players = players;

        ObservableList<Node> children = dotsAndLines.getChildren();
        this.setPrefSize(boardSize, boardSize);

        gap = (double) (boardSize - 200) / dotsCount;

        int boxIndex = -1;
        this.getChildren().addAll(boxes, dotsAndLines);
        for (int i = 0; i < dotsCount; i++) {
            for (int j = 0; j < dotsCount; j++) {
                Dot dot = new Dot();
                double X = getCoordinate(j);
                double Y = getCoordinate(i);
                Box box = new Box(X, Y, gap);
                boxIndex++;
                boxes.getChildren().add(box);
                dot.setCenterX(X);
                dot.setCenterY(Y);
                if(j < dotsCount - 1){
                    HLine line = new HLine(X, Y, gap);
                    line.boxes.add(box);
                    if(i != 0){
                        line.boxes.add((Box) boxes.getChildren().get(boxIndex - dotsCount));
                    }

                    children.add(line);
                    line.setOnMouseClicked(event -> lineClicked(line));
                }
                if(i < dotsCount - 1){
                    VLine line = new VLine(X, Y, gap);
                    line.boxes.add(box);
                    if(j != 0){
                        line.boxes.add((Box) boxes.getChildren().get(boxIndex - 1));
                    }
                    children.add(line);
                    line.setOnMouseClicked(event -> lineClicked(line));
                }
                children.add(dot);
            }

        }
    }
    static double getCoordinate(int x){
        return 100 + (x + 0.5) * gap;
    }
    void checkForBoxes(BaseLine line){
        for(Box box: line.boxes){
            boolean activated = box.addLine();
            if(activated){
                Player playingPlayer = getPlayingPlayer();
                box.setColor(playingPlayer.color);
                playingPlayer.increaseScore();
            }
        }
    }
    void lineClicked(BaseLine line){
        if(line.isColored()){
           return;
        }
        boolean colored = line.select(getPlayingPlayer().color);
        if(colored) {
            checkForBoxes(line);
        }
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
