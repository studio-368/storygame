package edu.bsu.storygame.views;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameWinView {

    GridPane grid;
    Label label;

    public Scene getWinningScene(){
        grid = new GridPane();
        grid.setMinSize(300,300);
        grid.setVgap(15);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        label = new Label("Win");
        grid.add(label,1,1);
        return new Scene(grid,300,300);
    }

}
