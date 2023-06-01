package com.example.boxanddotses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class GameScreen extends Pane {
    GridPane root;
    IntegerProperty[] scores;
    public GameScreen(Player[] players) {
        this.setWidth(1100);
        HBox root = new HBox();
        VBox p = new VBox();
        p.setPrefWidth(300);
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        p.setBorder(border);
//        BackgroundFill backgroundFill =
//                new BackgroundFill(
//                        Color.valueOf("#ff00ff"),
//                        new CornerRadii(0),
//                        new Insets(5)
//                );
//
//        Background background =
//                new Background(backgroundFill);
//

        Label l1 = new Label("Players");
        l1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 40));
        p.setAlignment(Pos.TOP_CENTER);
        Font playerFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25);

        VBox scoreBoard = new VBox();

        scoreBoard.getChildren().add(l1);
        scoreBoard.setAlignment(Pos.TOP_CENTER);
        scoreBoard.setBorder(border);
        p.getChildren().add(scoreBoard);
        for (Player player :
                players) {
            IntegerProperty score = new SimpleIntegerProperty(0);
            player.setScoreProperty(score);
            HBox playerBox = new HBox();
            playerBox.setPadding(new Insets(5));
            Label playerName = new Label(player.name);
            playerBox.setSpacing(5);
            playerBox.setPadding(new Insets(10));
            Label scoreLabel = new Label();
            playerName.setFont(playerFont);
            playerName.setTextFill(player.color);
            scoreLabel.setTextFill(player.color);
            scoreLabel.setFont(playerFont);
            scoreLabel.textProperty().bind(score.asString());

//            p.getChildren().add(playerBox);
            scoreBoard.getChildren().add(playerBox);
            playerBox.getChildren().addAll(playerName, scoreLabel);
        }


        ObservableList<Node> children =  this.getChildren();
        children.add(root);
        GameBoard gameBoard = new GameBoard(8, players);
        root.getChildren().addAll(gameBoard, p);


    }
}
