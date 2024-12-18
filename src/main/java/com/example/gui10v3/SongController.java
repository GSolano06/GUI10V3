package com.example.gui10v3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;


public class SongController {
    @FXML
    public ArrayList<Image> allImages;
    public TextField rankText;
    public TextField artistText;
    public TextField streamText;
    public TextField dateText;
    public TextField titleText;
    public ImageView choosenIv;
    public Button previousButton;
    public Button nextButton;
    public Button imageUploadButton;
    public MenuButton fileMenu;
    static int currentSongNumber = 0;


public void initialize() throws Exception {
    Song.readAllSongData();

Song firstSong = Song.allSongs.get(currentSongNumber);
    rankText.setText(String.valueOf(firstSong.getRank()));
    artistText.setText(String.valueOf(firstSong.getArtist()));
    streamText.setText(String.valueOf(firstSong.getStreams()));
    dateText.setText(String.valueOf(firstSong.getYear()));
    titleText.setText(String.valueOf(firstSong.getTitle()));
    Image possibleImage = firstSong.getSongCoverImage();
    if (possibleImage != null) {
        choosenIv.setImage(firstSong.getSongCoverImage());
        imageUploadButton.setText(" ");
    } else {
        imageUploadButton.setText("Upload Image");
    }

}



    public void previousData() {
        if (currentSongNumber > 0) {
            currentSongNumber = currentSongNumber - 1;
        } else {
            currentSongNumber = Song.allSongs.size()-1;
        }
        Song prevSong = Song.allSongs.get(currentSongNumber);
        rankText.setText(String.valueOf(prevSong.getRank()));
        artistText.setText(String.valueOf(prevSong.getArtist()));
        streamText.setText(String.valueOf(prevSong.getStreams()));
        dateText.setText(String.valueOf(prevSong.getYear()));
        titleText.setText(String.valueOf(prevSong.getTitle()));
        choosenIv.setImage(prevSong.getSongCoverImage());
        Image possibleImage = prevSong.getSongCoverImage();
        if (possibleImage != null) {
            choosenIv.setImage(prevSong.getSongCoverImage());
            imageUploadButton.setText(" ");
        } else {
            imageUploadButton.setText("Upload Image");
        }
    }

    public void nextData() {
        if (currentSongNumber < Song.allSongs.size() - 2) {
            currentSongNumber = currentSongNumber + 1;
        } else {
            currentSongNumber = 0;
        }
        Song nextSong = Song.allSongs.get(currentSongNumber);
        rankText.setText(String.valueOf(nextSong.getRank()));
        artistText.setText(String.valueOf(nextSong.getArtist()));
        streamText.setText(String.valueOf(nextSong.getStreams()));
        dateText.setText(String.valueOf(nextSong.getYear()));
        titleText.setText(String.valueOf(nextSong.getTitle()));
        choosenIv.setImage(nextSong.getSongCoverImage());
        Image possibleImage = nextSong.getSongCoverImage();
        if (possibleImage != null) {
            choosenIv.setImage(nextSong.getSongCoverImage());
            imageUploadButton.setText(" ");
        } else {
            imageUploadButton.setText("Upload Image");
        }
    }

    public void imageUpload() throws FileNotFoundException {
        Song selectedSong = Song.allSongs.get(currentSongNumber);
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(imageUploadButton.getScene().getWindow());
        FileInputStream input1 = new FileInputStream(selectedFile);
        Image chosenImage = new Image(input1);
        selectedSong.setSongCoverImage(chosenImage);
        choosenIv.setImage(selectedSong.getSongCoverImage());
        Image possibleImage = selectedSong.getSongCoverImage();
        if (possibleImage != null) {
            choosenIv.setImage(selectedSong.getSongCoverImage());
            imageUploadButton.setText(" ");
        } else {
            imageUploadButton.setText("Upload Image");
        }
    }
    public void rankChanged() {
        String newRank = rankText.getText();
        Song currentSong = Song.allSongs.get(currentSongNumber);
        currentSong.setRank(Integer.valueOf(newRank));

    }
    public void artistChanged() {
        String newArtist = artistText.getText();
        Song currentSong = Song.allSongs.get(currentSongNumber);
        currentSong.setArtist(newArtist);
    }
    public void titleChanged() {
        String newTitle = titleText.getText();
        Song currentSong = Song.allSongs.get(currentSongNumber);
        currentSong.setTitle(newTitle);
    }
   public void streamsChanged() {
        String newStreams = streamText.getText();
        Song currentSong = Song.allSongs.get(currentSongNumber);
        currentSong.setStreams(Double.valueOf(newStreams));
    }


    public void dateChanged() {
        String newDate = dateText.getText();
        Song currentSong = Song.allSongs.get(currentSongNumber);
        currentSong.setYear(newDate);

    }
}
