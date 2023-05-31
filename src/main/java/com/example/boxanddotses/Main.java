package com.example.boxanddotses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    ScreenController controller;
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1100, 800);
        controller = new ScreenController(scene);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        GameScreen gameScreen = new GameScreen();
        controller.addScreen("game", gameScreen);
        controller.activate("game");
    }

    public static void main(String[] args) {
        launch();
    }
}