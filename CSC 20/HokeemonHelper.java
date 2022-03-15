/*
Name: First Last
Date: 12-11-21
Programming Assignment: Programming Assignment 7&8
*/

import java.io.*;
import java.util.*;

public class HokeemonHelper {

    // method to read the data from a txt file and return an array that stores Hokeemon objects
    public static Hokeemon[] getData(String dataFile)
         {
            // do a try catch
            Hokeemon [] creatures = new Hokeemon[8];
            try {
                Scanner scan = new Scanner(new File(dataFile));
                // since there is 8 creatures loop 8 times
                for (int i =0; i<8; i++) {
                    creatures[i] = new Hokeemon(scan.next(), scan.next(), scan.nextInt());
                }

                
            } catch (IOException ioExc) {
                System.out.printf("Unable to open the data file %s", dataFile);
            } catch (Exception e) {
                System.out.println("Uncaught Exception opening the data file");
            }
            return creatures;

    }

    public static String getBio(Hokeemon creature, Hokeemon[] creatures) {
        String information = String.format("I am %s: Type %s: Age %d, I live in the %s.\nMy friends are:",
                                            creature.getName(), creature.getType(), creature.getAge(), 
                                            creature.liveIn()
                                        );

        // String friendsInformation = String.format("My friends are:");

        // add the friends from the array to the list
        for (Hokeemon friend : creatures) {
            if (creature.areFriends(friend) && friend.getName() != creature.getName()) {
                information += " " + friend.getName();
            }
        }

        return information;
    }
}

