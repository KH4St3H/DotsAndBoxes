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
        Pane root = new Pane();
        Scene scene = new Scene(root, 1100, 800);
        controller = new ScreenController(scene);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        PlayerManager managerScreen = new PlayerManager(controller);

        controller.addScreen("playerManager", managerScreen);
        controller.activate("playerManager");
    }

    public static void main(String[] args) {
        launch();
    }
}