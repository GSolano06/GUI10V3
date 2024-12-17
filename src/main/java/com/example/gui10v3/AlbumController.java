package com.example.gui10v3;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class AlbumController {
    // table stuff
    public TableView<Album> tableView;
    public TableColumn<Album, Integer> column1; // rank
    public TableColumn<Album, String> column2; // title
    public TableColumn<Album, String> column3; // artist
    public TableColumn<Album, String> column4; // year
    public TableColumn<Album, Integer> column5; // r s
    public TableColumn<Album, String> column6; // genre
    public TableColumn<Album, String> column7; // total cert copies

    public Button uploadButton;
    public Button prevButton;
    public Button nextButton;
    public ImageView imageView;

    // search bar
    public TextField searchBar;

    // text areas
    public Label rankingLabel;
    public TextArea rankingTextArea;
    public Label titleLabel;
    public TextArea titleTextArea;
    public Label artistLabel;
    public TextArea artistTextArea;
    public Label yearLabel;
    public TextArea yearTextArea;

    public void initialize() throws Exception {
        Album.readAllData();
        uploadButton.setDisable(true);
        // set up columns
        column1.setCellValueFactory(new PropertyValueFactory<>("rank"));
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));
        column3.setCellValueFactory(new PropertyValueFactory<>("artist"));
        column4.setCellValueFactory(new PropertyValueFactory<>("year"));
        column5.setCellValueFactory(new PropertyValueFactory<>("reportedSales"));
        column6.setCellValueFactory(new PropertyValueFactory<>("genre"));
        column7.setCellValueFactory(new PropertyValueFactory<>("totalCertifiedCopies"));


        // supposed to make editable

        column1.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        column2.setCellFactory(TextFieldTableCell.forTableColumn());
        column3.setCellFactory(TextFieldTableCell.forTableColumn());
        column4.setCellFactory(TextFieldTableCell.forTableColumn());

        column1.setOnEditCommit(
                (TableColumn.CellEditEvent<Album, Integer> t)  -> {
            int selectedRow = t.getTablePosition().getRow();
            Album selectedAlbum = t.getTableView().getItems().get(selectedRow);
            selectedAlbum.setRank(t.getNewValue());
            updateTextFields();
        }
        );

        column2.setOnEditCommit(
                (TableColumn.CellEditEvent<Album, String> t)  -> {
                    int selectedRow = t.getTablePosition().getRow();
                    Album selectedAlbum = t.getTableView().getItems().get(selectedRow);
                    selectedAlbum.setTitle(t.getNewValue());
                    updateTextFields();
                }
        );

        column3.setOnEditCommit(
                (TableColumn.CellEditEvent<Album, String> t)  -> {
                    int selectedRow = t.getTablePosition().getRow();
                    Album selectedAlbum = t.getTableView().getItems().get(selectedRow);
                    selectedAlbum.setArtist(t.getNewValue());
                    updateTextFields();
                }
        );

        column4.setOnEditCommit(
                (TableColumn.CellEditEvent<Album, String> t)  -> {
                    int selectedRow = t.getTablePosition().getRow();
                    Album selectedAlbum = t.getTableView().getItems().get(selectedRow);
                    selectedAlbum.setYear(t.getNewValue());
                    updateTextFields();
                }
        );

        for (Album allAlbums : Album.getAllAlbums()) {
            tableView.getItems().add(allAlbums);
        }

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
          uploadButton.setDisable(false);
          prevButton.setDisable(false);
          nextButton.setDisable(false);
            updateTextFields();
            fillImage();
        } );

        // make this work later
        prevButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.KP_LEFT) {
              previous();
            }
        });
        prevButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.KP_RIGHT) {
                next();
            }
        });
    }

   public void updateTextFields() {
     Album selectedAlbum =  tableView.getSelectionModel().getSelectedItem();
        System.out.println("ListView select newValue: " + selectedAlbum);
        if (selectedAlbum != null) {
            rankingTextArea.setText(String.valueOf(selectedAlbum.getRank()));
            titleTextArea.setText(String.valueOf(selectedAlbum.getTitle()));
            artistTextArea.setText(String.valueOf(selectedAlbum.getArtist()));
            yearTextArea.setText(String.valueOf(selectedAlbum.getYear()));
        } else {
            rankingTextArea.setText("");
            titleTextArea.setText("");
        }
    }

    public void setUploadButton()throws FileNotFoundException {
        Album selectedAlbum =  tableView.getSelectionModel().getSelectedItem();
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(tableView.getScene().getWindow());
        FileInputStream input = new FileInputStream(selectedFile);
        Image chosenImage = new Image(input);
        imageView.setImage(chosenImage);
        selectedAlbum.setAlbumImage(chosenImage);
    }

    public void fillImage(){
        if (tableView.getSelectionModel().getSelectedItem().getAlbumImage() == null){
            imageView.setImage(null);
        }
        else if(tableView.getSelectionModel().getSelectedItem().getAlbumImage()!= null){
            imageView.setImage(tableView.getSelectionModel().getSelectedItem().getAlbumImage());
        }
    }

    public void previous(){
       Integer selectedIndex = tableView.getSelectionModel().getSelectedIndex();
       tableView.getSelectionModel().clearAndSelect(selectedIndex-1);
    }
    public void next(){
        Integer selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        tableView.getSelectionModel().clearAndSelect(selectedIndex+1);
    }
    public void search(){
    // MAKE THIS WORK
    }
        }

