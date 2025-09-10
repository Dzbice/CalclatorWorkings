package org.openjfx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application{
    private final StringProperty equation = new SimpleStringProperty("");
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage){
        Scene scene = new Scene(createContent(),600,600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContent() {
        VBox results = new VBox(20,createEQLabel(),numberButtons());
        results.setAlignment(Pos.CENTER);
        return results;
    }

    private Node createEQLabel(){
        Label results = new Label("");
        results.textProperty().bindBidirectional(equation);
        results.getStyleClass().add("equation-label");
        return results;
    }

    private Node numberButtons(){
        ArrayList<Button> numbers = new ArrayList<>();
        for(int i = 1;i<10;i++){
            numbers.add(new Button(String.valueOf(i)));
            numbers.get(i-1).getStyleClass().add("number-button");
            String s = equation.get();
            int currentindex = i-1;
            numbers.get(i-1).setOnAction(evt -> equation.set(equation.get() +numbers.get(currentindex).getText()));
        }
        HBox hnums = new HBox(new VBox(numbers.get(6),numbers.get(3),numbers.get(0)), new VBox(numbers.get(7),numbers.get(4),numbers.get(1)), new VBox(numbers.get(8),numbers.get(5),numbers.get(2)));
        hnums.setAlignment(Pos.CENTER);
        return hnums;
    }


}