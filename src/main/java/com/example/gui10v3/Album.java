package com.example.gui10v3;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Album extends Music implements Serializable {
    private static final long serialVersionUID = 1L;
    private Float totalCertifiedCopies;
    private Integer reportedSales;
    private String genre;
    private transient Image albumImage;
    public static  ArrayList<Album> allAlbums = new ArrayList<Album>();


    public Album(String artist, String year, Integer rank, String title, Float totalCertifiedCopies, Integer reportedSales, String genre) {
        super(artist, year, rank, title);
        this.totalCertifiedCopies = totalCertifiedCopies;
        this.reportedSales = reportedSales;
        this.genre = genre;
    }

    public String getGenre() {return genre;}

    public Integer getReportedSales() {
        return reportedSales;
    }
    public Float getTotalCertifiedCopies() {
        return totalCertifiedCopies;
    }
    public static ArrayList<Album> getAllAlbums(){
        return allAlbums;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReportedSales(Integer reportedSales) {
        this.reportedSales = reportedSales;
    }

    public void setTotalCertifiedCopies(Float totalCertifiedCopies) {
        this.totalCertifiedCopies = totalCertifiedCopies;
    }

    public void setAlbumImage(Image albumImage) {
        this.albumImage = albumImage;
    }

    public Image getAlbumImage() {
        return albumImage;
    }

    public String toString(){
    return "Album title: " + getTitle()+ " Artist: " + getArtist()+ " Year: " + getYear() + " Genre: " + getGenre() + " Total Copies Sold: " + getReportedSales() + " Rank: " + getRank()+ " Total Certified Copies: "+ getTotalCertifiedCopies();
    }

    public static void readAllData() throws Exception{
        File dataFile = new File ("src/BestSellingAlbumsList");
        Scanner textScanner = new Scanner(dataFile);
        textScanner.useDelimiter("\n");
        int currentRank = 0;
        while (textScanner.hasNext()) {
            // Extract individual line/row for scanning
            String fullRow1 = textScanner.nextLine();
           // System.out.println(fullRow1);
            Scanner rowScanner1 = new Scanner(fullRow1);
            // Each row has data chunks separated by tabs \t
            rowScanner1.useDelimiter("\t");
            String fullRow2 = textScanner.nextLine();
            //System.out.println(fullRow2);
            Scanner rowScanner2 = new Scanner(fullRow2);
            rowScanner2.useDelimiter("\t");
            String fullRow3 = textScanner.nextLine();
            Scanner rowScanner3 = new Scanner(fullRow3);
           // System.out.println(fullRow3);

            rowScanner3.useDelimiter("\t");
            // Now turn each next chunk of data into your object's values
        /*Michael Jackson	Thriller	1982	Pop, post-disco, funk, rock
        51.3
        70	[4][5]*/

            String data1;
            data1 = rowScanner1.next();

            String data2 = rowScanner1.next();

            String data3 = rowScanner1.next();
            int intdata3 = Integer.parseInt(data3);

            String data4 = rowScanner1.next();

            String data5 = rowScanner2.next();
            float floatdata5 = Float.parseFloat(data5);

            String data6 = rowScanner3.next();
            int intdata6 = Integer.parseInt(data6);

            String data7 = rowScanner3.next();
            //ignore this
            //String artist, String year, Integer rank, String title, Double totalCertifiedCopies, Integer reportedSales, String genre
            currentRank = currentRank + 1;

            Album newAlbum = new Album(data1, data3, currentRank, data2, floatdata5, intdata6*1000000, data4);
            allAlbums.add(newAlbum);
           // System.out.println(newAlbum);



        }

    }
    static void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedAlbumsFile");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(allAlbums);
        objectOut.close();
        fileOut.close();
    }

    static void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("SavedAlbumsFile");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        allAlbums = (ArrayList<Album>)objectIn.readObject();
        objectIn.close();
        fileIn.close();
    }

    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        // write NON-transient fields
        s.defaultWriteObject();
        // write transient fields
        if (albumImage != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(albumImage, null), "png", s);
        }
    }

    // implements custom deserialize for
//     transient posterImage field
    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
// read NON-transient fields
        s.defaultReadObject();
        // read transient fields
        Image maybeAlbumImage = null;
        try {
            maybeAlbumImage = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception ex) {
            // do nothing
        }
        albumImage = maybeAlbumImage;
    }

}
