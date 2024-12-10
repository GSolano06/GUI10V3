package com.example.gui10v3;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class AlbumController {
    // table stuff
    public TableView tableView;
    public TableColumn<Music, Integer> column1; // rank
    public TableColumn<Music, String> column2; // title
    public TableColumn<Music, String> column3; // artist
    public TableColumn<Music, String> column4; // year
    public TableColumn<Album, String> column5; // r s
    public TableColumn<Album, String> column6; // genre
    public TableColumn<Album, String> column7; // total cert copies



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

        // set up columns
        column1.setCellValueFactory(new PropertyValueFactory<>("rank"));
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));
        column3.setCellValueFactory(new PropertyValueFactory<>("artist"));
        column4.setCellValueFactory(new PropertyValueFactory<>("year"));
        column5.setCellValueFactory(new PropertyValueFactory<>("reportedSales"));
        column6.setCellValueFactory(new PropertyValueFactory<>("genre"));
        column7.setCellValueFactory(new PropertyValueFactory<>("totalCertifiedCopies"));

        for (Album allAlbums : Album.getAllAlbums()) {
            tableView.getItems().add(allAlbums);
        }
    }
    public void fillRank(){

    }

    public void fillTitle(){

    }

    public void fillArtist(){

    }

    public void fillYear(){

    }
}