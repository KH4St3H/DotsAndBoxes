package com.example.boxanddotses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    ScreenController controller;
    Player[] players;
    @Override
    public void start(Stage stage) throws IOException {
        Player player1 = Player.create("Mehrshad", Color.rgb(24, 230, 100));
        Player player2 = Player.create("Sina", Color.rgb(150, 10, 190));
        players = new Player[]{player1, player2};


        Pane root = new Pane();
        Scene scene = new Scene(root, 1100, 800);
        controller = new ScreenController(scene);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        GameScreen gameScreen = new GameScreen(players);
        controller.addScreen("game", gameScreen);
        controller.activate("game");
    }

    public static void main(String[] args) {
        launch();
    }
}