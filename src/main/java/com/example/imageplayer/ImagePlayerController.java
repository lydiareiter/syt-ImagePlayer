package com.example.imageplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;

public class ImagePlayerController {
    @FXML
    public Label filepath;
    @FXML
    public ImageView imageview;
    @FXML
    public BorderPane borderPane;

    @FXML
    public void onLoadClicked(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.setInitialDirectory(new File("./src/images"));
        File imageFile = fileChooser.showOpenDialog(null);
        filepath.setText(imageFile.getName());
        setImage(new Image(imageFile.toURI().toString()));
    }
    private void setImage(Image image){
        int width =Math.min(600, (int)(image.getWidth()*0.25));
        int height =Math.min(600, (int)(image.getHeight()*0.25));
        ImageDiscoverer discoverer = new ImageDiscoverer(image);

        imageview.setImage(discoverer.getDestinationImage());
        imageview.setFitWidth(width);
        imageview.setFitHeight(height);
        borderPane.setCenter(null);
        borderPane.setCenter(imageview);
        //borderPane.setPrefHeight(height + buttonBar.getPrefHeight());
        borderPane.setPrefHeight(height + 25);
        //borderPane.setPrefWidth(Math.max(width, buttonBar.getPrefWidth()));
        borderPane.setPrefWidth(Math.max(width, 100));
        Scene scene = borderPane.getScene();
        if (scene != null){
            scene.getWindow().sizeToScene();
        }
    }
}