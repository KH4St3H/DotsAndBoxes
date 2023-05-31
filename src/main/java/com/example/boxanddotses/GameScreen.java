package com.example.boxanddotses;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GameScreen extends Pane {
    GridPane root;
    public GameScreen() {
        this.setWidth(1100);
        HBox root = new HBox();
        Pane p = new Pane();
        p.setPrefWidth(300);
        BackgroundFill backgroundFill =
                new BackgroundFill(
                        Color.valueOf("#ff00ff"),
                        new CornerRadii(10),
                        new Insets(10)
                );

        Background background =
                new Background(backgroundFill);

        p.setBackground(background);
        Button b = new Button("hello");
        p.getChildren().add(b);
        ObservableList<Node> children =  this.getChildren();
        children.add(root);
        GameBoard gameBoard = new GameBoard(8);
        root.getChildren().addAll(gameBoard, p);


    }
}
