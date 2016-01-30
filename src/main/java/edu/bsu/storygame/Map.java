package edu.bsu.storygame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map extends StoryGame {


    public ImageView mapImageView(){
        Image map =  new Image(getClass().getResourceAsStream("/WorldMap.png"));
        ImageView mapImageView = new ImageView();
        mapImageView.toBack();
        mapImageView.setFitHeight(500);
        mapImageView.setFitWidth(500);
        mapImageView.toBack();
        mapImageView.setImage(map);
        return  mapImageView;
    }
}
