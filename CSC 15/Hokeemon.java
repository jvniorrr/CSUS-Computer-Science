/*
Name: First Last
Date: 12-11-21
Programming Assignment: Programming Assignment 7&8
*/

public class Hokeemon {
    private String name, type, location;
    private int age;
    private String[] friends = new String[2];

    public Hokeemon() {
        this.name = "";
        this.type = "";
        this.age = 0;

        // set the data for the hokemon
        setData(this.type.toLowerCase());
    }

    public Hokeemon(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

        // set the data for the hokemon
        setData(this.type.toLowerCase());
    }

    // getter methods to return the name
    public String getName() {
        return this.name;
    }
    // getter methods to return type of hokeemon
    public String getType() {
        return this.type;
    }
    // getter methods to return age
    public int getAge() {
        return this.age;
    }

    // a toString method needs to be written
    public String toString() {
        // return String.format("Hokeemon(%s, %s, %d)", this.name, this.type, this.age);
        return String.format("\nName %s: Type %s: Age %d", this.name, this.type, this.age);
    }

    // create instance methods liveIn() that returns the home of the hokeemon
    public String liveIn() {
        return this.location;
    }

    // create a method to make areFriends a bit easier to utilize / only use a loop
    public void setData(String type) {
        friends[0] = this.type;
        // add friends depending on type
        if (type.equalsIgnoreCase("dwarf")) {
            friends[1] = "Elf";
            // set the location
            this.location = "Mountain";

        } else if (type.equalsIgnoreCase("elf")) {
            friends[1] = "Dwarf";
            // set the location
            this.location = "Dale";

        } else if (type.equalsIgnoreCase("hobbit") ) {
            friends[1] = "Fairy";
            // set the location
            this.location = "Shire";

        } else if (type.equalsIgnoreCase("fairy")) {
            friends[1] = "Hobbit";
            // set the location
            this.location = "Forest";

        } else {
            friends[1] = "";

            // set the location
            this.location = "Default";
        }
        
    }
    public boolean areFriends(Hokeemon friendObj) {
        for (String friend: friends) {
            // we are checking string of friends that are stored in the array friends
            if (friend.equalsIgnoreCase(friendObj.getType())) {
                return true;
            }
        }
        // else if nothing found in the for loop return false
        return false;
    }
}
