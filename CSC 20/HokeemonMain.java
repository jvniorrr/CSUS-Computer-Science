/*
Name: First Last
Date: 12-11-21
Programming Assignment: Programming Assignment 7&8
*/

import java.io.*;
import java.util.Arrays;

public class HokeemonMain {
    public static String dataFile = "Data.txt";

    public static void main(String[] args)
        throws FileNotFoundException{
            
        
            try {
                Hokeemon[] creatures = new Hokeemon[8];

                creatures = HokeemonHelper.getData(dataFile);

                System.out.println(Arrays.toString(creatures) + "\n");

                for (int i=0; i<8; i++) {
                    System.out.println(HokeemonHelper.getBio(creatures[i], creatures));
                }
                
            } catch (Exception e) {
                System.out.println("Uncaught exception; Maybe IO Exception");
            }
    }
}
