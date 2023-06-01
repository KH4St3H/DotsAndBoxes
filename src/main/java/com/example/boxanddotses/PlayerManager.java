package com.example.boxanddotses;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PlayerManager extends Pane {
    public PlayerManager(ScreenController controller){
        this.setPadding(new Insets(10));

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);

        ArrayList<Player> players = new ArrayList<>();

        HBox inputs = new HBox();
        inputs.setSpacing(3);
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label colorLabel = new Label("Color:");
        ColorPicker picker = new ColorPicker();
        Button addButton = new Button("add");
        inputs.getChildren().addAll(nameLabel, nameField, colorLabel, picker, addButton);
        addButton.setOnMouseClicked(event -> {
            Player player = Player.create(nameField.getText(), picker.getValue());
            players.add(player);
            Label label = new Label(player.name);
            root.getChildren().add(label);
        });
        Button playButton = new Button("Play");
        root.getChildren().addAll(inputs, playButton);

        this.getChildren().add(root);
        playButton.setOnMouseClicked(mouseEvent -> {
            Player[] playersList = new Player[players.size()];
            for (int i = 0; i < players.size(); i++) {
                playersList[i] = players.get(i);

            }
            GameScreen gameScreen = new GameScreen(playersList);
            controller.addScreen("gameScreen", gameScreen);
            controller.activate("gameScreen");

        });


    }
}
