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

   // Tours.readAllData();
   // Tours.describeAllTours();


    public void initialize() throws Exception{
        Tours.readAllData();


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