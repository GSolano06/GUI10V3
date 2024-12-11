package com.example.gui10v3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Album extends Music {
    private Float totalCertifiedCopies;
    private Integer reportedSales;
    private String genre;
    static  ArrayList<Album> allAlbums = new ArrayList<Album>();


    public Album(String artist, String year, Integer rank, String title, Float totalCertifiedCopies, Integer reportedSales, String genre) {
        super(artist, year, rank, title);
        this.totalCertifiedCopies = totalCertifiedCopies;
        this.reportedSales = reportedSales;
        this.genre = genre;
    }

    public String getGenre() {return genre;}
    public Integer getTotalReportedSales() {
        return reportedSales;
    }
    public Float getTotalCertifiedCopies() {
        return totalCertifiedCopies;
    }
    public static ArrayList<Album> getAllAlbums(){
        return allAlbums;
    }



    public String toString(){
    return "Album title: " + getTitle()+ " Artist: " + getArtist()+ " Year: " + getYear() + " Genre: " + getGenre() + " Total Copies Sold: " + reportedSales + " Rank: " + getRank()+ " Total Certified Copies: "+ getTotalCertifiedCopies();
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
            System.out.println(newAlbum);



        }

    }
}
