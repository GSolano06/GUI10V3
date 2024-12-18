package com.example.gui10v3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class ToursController {
    public Pane pane;
    public ImageView tourImage;
    public Button previousButton;
    public Button nextButton;
    public Button addImage;
    public Button returnButton;
    public TextField rankField;
    public TextField artistField;
    public TextField titleField;
    public TextField peakField;
    public TextField grossField;
    public TextField yearField;
    public TextField showField;
    public TextField dataCounter;
    public TextField outOfCounter;
    FileChooser fileChooser = new FileChooser();

    static int currentTourNumber = 0;

    public void initialize() throws Exception {
        Tours.readAllData();

        Tours firstTour = Tours.getAllTours().get(currentTourNumber);
        rankField.setText(String.valueOf(firstTour.getRank()));
        artistField.setText(String.valueOf(firstTour.getArtist()));
        titleField.setText(String.valueOf(firstTour.getTitle()));
        peakField.setText(String.valueOf(firstTour.getPeakNumber()));
        grossField.setText(String.valueOf(firstTour.getActualGross()));
        yearField.setText(String.valueOf(firstTour.getYear()));
        showField.setText(String.valueOf(firstTour.getShows()));

        dataCounter.setText(String.valueOf(currentTourNumber + 1));
        outOfCounter.setText(String.valueOf(Tours.getAllTours().size()));

       // saveButton.setDisable(true);

    }

    public void previousTour() throws Exception {
        if(currentTourNumber > 0) {
            currentTourNumber = currentTourNumber - 1;
        } else {
            currentTourNumber = Tours.getAllTours().size()-1;
        }

            Tours previousTour = Tours.getAllTours().get(currentTourNumber);
            rankField.setText(String.valueOf(previousTour.getRank()));
            artistField.setText(String.valueOf(previousTour.getArtist()));
            titleField.setText(String.valueOf(previousTour.getTitle()));
            peakField.setText(String.valueOf(previousTour.getPeakNumber()));
            grossField.setText(String.valueOf(previousTour.getActualGross()));
            yearField.setText(String.valueOf(previousTour.getYear()));
            showField.setText(String.valueOf(previousTour.getShows()));

         dataCounter.setText(String.valueOf(currentTourNumber + 1));

        //Tours currentTour = Tours.getAllTours().get(currentTourNumber);
        tourImage.setImage(previousTour.getTourImage());
        

    }

    public void nextTour() throws Exception {
        if (currentTourNumber < Tours.getAllTours().size() - 1) {
            currentTourNumber = currentTourNumber + 1;
        } else {
            currentTourNumber = 0;
        }
            Tours currentTour = Tours.getAllTours().get(currentTourNumber);
            rankField.setText(String.valueOf(currentTour.getRank()));
            artistField.setText(String.valueOf(currentTour.getArtist()));
            titleField.setText(String.valueOf(currentTour.getTitle()));
            peakField.setText(String.valueOf(currentTour.getPeakNumber()));
            grossField.setText(String.valueOf(currentTour.getActualGross()));
            yearField.setText(String.valueOf(currentTour.getYear()));
            showField.setText(String.valueOf(currentTour.getShows()));

        dataCounter.setText(String.valueOf(currentTourNumber + 1));
        tourImage.setImage(currentTour.getTourImage());

        }

        public void editData() throws Exception {
            String newTitle = titleField.getText();
            Tours currentTour = Tours.getAllTours().get(currentTourNumber);
            currentTour.setTitle(newTitle);

            String newRank = rankField.getText();
            currentTour.setRank(Integer.valueOf(newRank));

            String newArtist = artistField.getText();
            currentTour.setArtist(newArtist);

            String newPeak = peakField.getText();
            currentTour.setPeakNumber(Integer.valueOf(newPeak));

            String newGross = grossField.getText();
            currentTour.setActualGross(Integer.valueOf(newGross));

            String newYear = yearField.getText();
            currentTour.setYear(newYear);

            String newShow = showField.getText();
            currentTour.setShows(Integer.valueOf(newShow));

        }

        public void insertImage () throws Exception {
            Tours currentTour = Tours.getAllTours().get(currentTourNumber);

            File selectedFile = fileChooser.showOpenDialog(tourImage.getScene().getWindow());
            FileInputStream selectedFIS = new FileInputStream(selectedFile);
            Image randomImage = new Image(selectedFIS);
            currentTour.setTourImage(randomImage);
            tourImage.setImage(randomImage);
        }

        public void changeToHome () throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("starterView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage homeStage = (Stage)returnButton.getScene().getWindow();
            homeStage.setTitle("Learn About Music");
            homeStage.setScene(scene);
            homeStage.show();
        }




    }


















