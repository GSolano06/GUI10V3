package com.example.gui10v3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SuperController {
public Button songButton;
public Button tourButton;
public Button albumButton;

public void initialize(){
}

    public void changeToSong() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("songView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage songStage = (Stage)songButton.getScene().getWindow();
        songStage.setTitle("Top Songs");
        songStage.setScene(scene);
        songStage.show();
    }
    public void changeToTour() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("toursView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage tourStage = (Stage)tourButton.getScene().getWindow();
        tourStage.setTitle("Top Tours!");
        tourStage.setScene(scene);
        tourStage.show();
    }
    public void changeToAlbum() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("albumsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage albumStage =(Stage)albumButton.getScene().getWindow();
        albumStage.setTitle("Top Albums!");
        albumStage.setScene(scene);
        albumStage.show();
    }

}

