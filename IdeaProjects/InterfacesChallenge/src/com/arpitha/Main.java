package com.arpitha;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// create an simple interface that allows an object to be saved to some part of storage medium
        // the exact type of medium is not known to the interface(nor to the classes that implements it).
        //The interface will just specify two methods, one to return an ArrayList of values to be saved
        //and other to populate the object field from the ArrayList.

        //create some sample classes that implements saveable interface.
        //Override the toString() method for each classes so that they can easily be printed to enable the program
        //to be tested easier.
        //In main, write the method that takes an object that implements the interfaces as a parameter and
        // "saves" the values.

        Player snow = new Player("Snow", 10,15);
        System.out.println(snow.toString()); //output on screen
        saveObjects(snow);

        snow.setHitPoints(8);
        System.out.println("snow");
        snow.setWeapons("strombringer");
        saveObjects(snow);
        //loadObject(snow);
        System.out.println(snow);

        ISaveable werewolf = new Monster("werewolf", 20, "40");
        System.out.println(werewolf);
        saveObjects(werewolf);



    }
 public static ArrayList<String > readvalues() {
    ArrayList<String> values = new ArrayList<String >();
     Scanner scanner = new Scanner(System.in);
     boolean quit = false;
     int index = 0;
     System.out.println(" choose\n" +
     "1 - to print the string\n" +
     "0 - to quit");

     while (! quit){
         System.out.println(" choose an options");
         int choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice){
             case 0:
                // System.out.println("Playlist complete");
                 quit=true;
                 break;
             case 1:
                 System.out.println("enter a string");
                 String stringInput = scanner.nextLine();
                 values.add(index, stringInput);
                 index++;
                 break;
                     }

    }
    return values;
}

public static void saveObjects(ISaveable objectToSave) {
        for (int i=0; i<objectToSave.write().size(); i++){ //circulate the entire write() method
            System.out.println("saving" + objectToSave.write().get(i) + "to storage device");
        }
}

public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readvalues();  //get the data
        objectToLoad.read(values);  //read from the read() method and store the object in values
}


































}
