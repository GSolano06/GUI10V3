package com.example.gui10v3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ToursController {
    public Pane pane;
    public ImageView tourImage;
    public Button previousButton;
    public Button nextButton;
    public Button addImage;
    public Button saveButton;
    public TextField rankField;
    public TextField artistField;
    public TextField titleField;
    public TextField peakField;
    public TextField grossField;
    public TextField yearField;
    public TextField showField;
    public TextField dataCounter;

    static int currentTourNumber = 0;

    public void initialize() throws Exception{
        Tours.readAllData();

        Tours firstTour = Tours.getAllTours().get(currentTourNumber);
        rankField.setText(String.valueOf(firstTour.getRank()));
        artistField.setText(String.valueOf(firstTour.getArtist()));
        titleField.setText(String.valueOf(firstTour.getTitle()));
        peakField.setText(String.valueOf(firstTour.getPeakNumber()));
        grossField.setText(String.valueOf(firstTour.getActualGross()));
        yearField.setText(String.valueOf(firstTour.getYear()));
        showField.setText(String.valueOf(firstTour.getShows()));

        dataCounter.setText("1");

    }

    public void tourData() throws Exception{

    }

    public void previousTour() throws Exception {

    }

    public void nextTour() throws Exception {

    }

    public void counter() throws Exception {

    }
















}