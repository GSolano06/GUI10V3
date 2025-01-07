package com.example.gui10v3;

import com.example.gui10v3.Music;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Tours extends Music implements Serializable{
    private static final long serialVersionUID = 1L;
    private int peakNumber;
    private int actualGross;
    private int shows;
    private transient Image tourImage;

    private static ArrayList<Tours> allTours = new ArrayList<Tours>();

    public Tours(String artist, String year, Integer rank, String title, int peakNumber, int actualGross, int shows) {
        super(artist, year, rank, title);
        this.peakNumber = peakNumber;
        this.actualGross = actualGross;
        this.shows = shows;
    }

    //getters and setters

    public Image getTourImage() {
        return tourImage;
    }

    public void setTourImage(Image tourImage) {
        this.tourImage = tourImage;
    }

    public int getPeakNumber() {
        return peakNumber;
    }

    public void setPeakNumber(int peakNumber) {
        this.peakNumber = peakNumber;
    }
    public static ArrayList<Tours> getAllTours() {
        return allTours;
    }

    public static void setAllTours(ArrayList<Tours> allTours) {
        Tours.allTours = allTours;
    }

    public int getActualGross() {
        return actualGross;
    }

    public void setActualGross(int actualGross) {
        this.actualGross = actualGross;
    }

    public int getShows () {
        return shows;
    }

    public void setShows (int shows){
        this.shows = shows;
    }

    public String toString () {
        return "Tour Title:" + getTitle() + "Artist:" + getArtist() + "Year(s):" + getYear() + "Rank:" + getRank() + "Peak Number:" + getPeakNumber() + "Shows:" + getShows();

    }
    static void readAllData() throws Exception {
        if (getAllTours().size()>0) {
            return;
        }

        System.out.println("READING TOURS");

        File dataTourData = new File("src/TourData");
        Scanner textScanner = new Scanner(dataTourData);
        textScanner.useDelimiter("\n");
        while (textScanner.hasNext()) {
            String fullRow = textScanner.nextLine();
            Scanner rowScanner = new Scanner(fullRow);
            rowScanner.useDelimiter("\t");

            // 1	1	$1,930,000,000	$1,930,000,000	Taylor Swift	The Eras Tour †	2023–2024	121	$15,950,413	[A]
            int data1 = rowScanner.nextInt();
            System.out.println("Rank:" + data1);

            String data2 = rowScanner.next();
            int data2int = Integer.parseInt(data2);
            System.out.println("Peak Number:" + data2int);

            String data3 = rowScanner.next();
            data3 = data3.substring(data3.indexOf("$") + 1);
            data3 = data3.replaceAll(",", "");
            int data3int = Integer.parseInt(data3);
            System.out.println("Actual Gross:" + data3int);

            String data8 = rowScanner.next();
            System.out.println("Ignore Data:" + data8);

            String data4 = rowScanner.next();
            System.out.println("Artist Name:" + data4);

            String data5 = rowScanner.next();
            System.out.println("Tour Title:" + data5);

            String data6 = rowScanner.next();
            System.out.println("Year(s)" + data6);

            String data7 = rowScanner.next();
            int data7int = Integer.parseInt(data7);
            System.out.println("Number of Shows:" + data7int);

            String data9 = rowScanner.next();
            System.out.println("Ignore Data:" + data9);
            String data10 = rowScanner.next();
            System.out.println("Ignore Data:" + data10);

            int rank = data1;
            String artist = data4;
            String title = data5;
            int actualGross = data3int;
            String year = data6;
            int peakNumber = data2int;
            int shows = data7int;

            Tours newTour = new Tours(artist, year, rank , title , peakNumber , actualGross , shows);
            //public Tours(String artist, String year, Integer rank, String title, int peakNumber, int actualGross, int shows) {

            allTours.add(newTour);
        }
    }

        static void describeAllTours() {
            for (Tours eachTour: allTours) {
                System.out.println(eachTour);
            }
        }

    static void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedTourObjects");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(allTours);
        objectOut.close();
        fileOut.close();
    }
    static void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("SavedTourObjects");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        allTours = (ArrayList<Tours>)objectIn.readObject();
        objectIn.close();
        fileIn.close();
    }
    // implements custom serialize for
    //     transient posterImage field
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        // write NON-transient fields
        s.defaultWriteObject();
        // write transient fields
        if (tourImage != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(tourImage, null), "png", s);
        }

    }
    // implements custom deserialize for
//     transient posterImage field
    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
// read NON-transient fields
        s.defaultReadObject();
        // read transient fields
        Image maybePoster = null;
        try {
            maybePoster = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception ex) {
            // do nothing
        }
        tourImage = maybePoster;
    }


}






