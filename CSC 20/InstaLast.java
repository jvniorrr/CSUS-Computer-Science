/*
Name: First Last
Self-Grade: 100
    - Formatted accordingly
    - Methods described
    - Vertical Ruler of 100 used

Date Program Created: 02/28/22
*/
import java.util.*;


class MyInstaDriver {
    public static void main(String[] args) {
        //your code here: should be similar to the given driver below
        // Create your own Driver and your own list of followers.
        SocialMedia myInsta = new SocialMedia();

        /*Adding followers to your list*/
        /*the boolean field indicates whether you want to follow them back*/
        // Add followers to the list you created
        myInsta.follow("Mukhtaar", "Darnell", "mDarnell", true);
        myInsta.follow("Patton", "Herbert",  "HerbertP", false);
        myInsta.follow("Carly", "Davis",  "iCarly", true);
        myInsta.follow("Quincy", "Elliot", "Quincing",true);
        myInsta.follow("Keith", "De Leon", "Keifers", false);

        /*Displaying your followers*/
        // Show the updated list
        System.out.println("Here is your updated Account information");
        System.out.println(myInsta);

        // Search for a follower that isn’t in the list
        String userFirst = "Jessie";
        String userLast = "Michaels";
        System.out.printf("Searching for user %s %s\n", userFirst, userLast);
        boolean searched = myInsta.search(userFirst, userLast);
        System.out.printf("The user %s %s was%s found\n\n", userFirst, userLast, (searched) ? " " : " not");

        // Remove a follower from your list
        System.out.println("Removing a follower from your list");
        myInsta.remove("Patton", "Herbert");

        // Show the updated list
        System.out.println("Here is your updated follower list.");
        System.out.println(myInsta);

        // Follow a person in your list of followers
        String followUserName = "Keifers";
        System.out.printf("Following a new user: %s\n", followUserName);
        myInsta.follow("Keith", "De Leon", "Keifers", true);
    }
}

// the java template given has this below named `Driver` which is also a class in AirplanMendoza
class OtherDriver {
    public static void main(String[]args) {
        SocialMedia myInsta = new SocialMedia();

        /*Adding followers to your list*/
        /*the boolean field indicates whether you want to follow them back*/
        myInsta.follow("Matthew", "Philips", "MatPhil", true);
        myInsta.follow("Gary", "Kane",  "GKane", false);
        myInsta.follow("Robert", "Kenny",  "RKenny", true);
        myInsta.follow("Bill", "Fitch", "BillF",true);
        myInsta.follow("Trevor", "Schlulz", "TrevorS", false);

        /*Displaying your followers*/
        System.out.println("Your followers informations\n");
        System.out.println(myInsta);

        /*Unfollowing a user*/
        System.out.println("Removing Robert Kenny from your followers list");
        myInsta.remove("Robert", "Kenny");

        /*Displaying the list*/
        System.out.println("List of followers after removing Robert Kenny");
        System.out.println(myInsta);

        /*adding a new follower*/
        System.out.println("Adding Elon Musk to your list of followers");
        myInsta.follow("Elon", "Musk", "ElonM", true);

        /*Displaying the followers*/
        System.out.println("List of your followers:");
        System.out.println(myInsta);

        /*Searching for a follower*/
        System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
        if(myInsta.search("Jackson", "Stonewall") == false) {
            System.out.println("Stonewall Jackson is not in your list of followers");
            System.out.println("\n***************************");
            System.out.println("You are following " + myInsta.followerCounts() + " people");

            System.out.println("You have " + myInsta.followingCounts() + " followers");
            System.out.println(myInsta);
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter the first and  last name from the list bellow that you want to follow back: ");

            String first =kb.next();
            String last = kb.next();
            myInsta.followBack(first,last);

            System.out.println(myInsta);

        }

    }
}

/** Represents a User object which can be used with an Insta Object
 * @author  First Last
 * @version 1.0
 * @param   first       The user's first name
 * @param   last        The user's last name
 * @param   username    The user's unique username
 * @param   followBack  A boolean value representing if a user follows another user.
*/
class User implements Comparable<User> {
    private String first;
    private String last;
    private String username;
    private boolean followBack;//set to true if you want to follow back the person
        
    // constructor for a USER obj
    public User(String first, String last, String username, boolean followBack){
        //your code
        this.first = first;
        this.last = last;
        this.username = username;
        this.followBack = followBack;
    }

    /*  GETTER METHODS */
    // method to return the first name
    public String getFirst() {
        return this.first;// change this line
    }
    // method to return the last name
    public String getLast() {
        return this.last;//chnage this line
    }
    // method to return the username of the user
    public String getUsername() {
        return this.username; //your code
    }
    // return the boolean value specifying if a user is following another user
    public boolean getFollow() {
        return this.followBack; // must change this line
    }


    /*  SETTER METHODS  */
    // method to set the first name
    public void setFirst(String first) {
        //your code
        this.first = first;
    }
    // method to set the last name
    public void setLast(String last) {
        //your code
        this.last = last;
    }


    /*  MISC. METHODS/FOLLOWING FUNCTION METHODS */
    // method to set follow back to false
    public void unfollow() {
        //your code
        this.followBack = false;
    }
    // method to set follow back to true
    public void follow() {
        //your code
        this.followBack = true;
    }

    /*  ABSTRACT METHODS PARTIALLY. COMPARING METHODS   */

    // method to compare objects
    // method to compare usernames between users
    @Override
    public int compareTo(User o) {
        // return 1;

        //your code
        // return a positive number if the index being compared to is larger. else negative
        // check if we can typecast / reference the object
        // if (o instanceof User) {
            // check if the user has the same username
            // typecast
        User other = (User)o;
            // String name = this.first + " " + this.last;
            // String otherName = other.getFirst() + " " + other.getLast();

        return (this.username).compareTo(other.getUsername()); // comparing the name of the players alphabetically

    }

    // compares two objects using the first and last name variables
    public boolean equals(User other) {
        //your code
        return this.first.equalsIgnoreCase(other.first) && this.last.equalsIgnoreCase(other.last);
        
    }

    // OBJECT REPRESENTATION
    public String toString() {
        //your code
        String s = String.format("User Name: %s\nName: %s\nLast Name: %s  \"You", this.username, this.first, this.last); 
        s += (this.followBack) ? " follow back this person" : " are not following this person";
        return s;
            
    }

}


/** Represents an Instagram account which contains information on user's followers and following count.
 * @author  First Last
 * @version 1.0
*/
class SocialMedia{
    private ArrayList<User> app;
        
    // constructor method
    SocialMedia() {
        app = new ArrayList<User>();
            
    }
    // method to follow a user bac; checks user's first and last names
    public void followBack(String first, String last) {
        //your code
        String s = first + " " + last;
        for(int i = 0; i < app.size(); i++) { 
            String s1 = app.get(i).getFirst() + " " + app.get(i).getLast();
            if(s1.equalsIgnoreCase(s)) { 
                app.get(i).follow(); 
            } 
        }
    }

    // Returning true means the follower was added, returning false means the follower is already in the list
    public boolean follow(String first, String last, String username, boolean followBack) {
            //your code
            // check if the user is already stored in the list
            boolean b = search(first, last);
            boolean added = false;

            // if the user is stored already, we will return false immediately
            if (b) {
                return false;
            }

            // if the false block above didnt run, we will create a User object
            User userObj = new User(first, last, username, followBack);

            // check if there is already entries in the list
            if (app.size() == 0) {
                // create
                app.add(userObj);
                // the user was added so we will return true
                added = true;
            }

            // if the list already contains entries, search through the middle to check
            for (int j=0; j<app.size(); j++) {
                if (userObj.compareTo(app.get(j)) < 0) {
                    app.add(j, userObj);
                    // the user was added so return true
                    added = true;
                    break;
                }
            }

            // if the blocks above were not executed then this block will be executed
            if (!added) {
                app.add(userObj);
                added = true;
            }
        
            return added; // must change
                                
    }
        
    /*  This method removes the person from the list meaning that they are not 
        following you and you are not following them
    */
    public boolean remove(String first, String last ) {
        //your code
        boolean b = search(first ,last);

        // if the user is not found in the list, 
        if (!b) {
            return false; // the user was not found the app list
        }

        String s = first + " " + last; // only do this once, not in loop

        // loop through the app and check the indexed object
        for (int i=0; i < app.size(); i++) {

            // store the looped index object to compare the name from it
            String otherObj = app.get(i).getFirst() + " " + app.get(i).getLast();

            // if the users name match then we will remove them from the list
            if (s.equalsIgnoreCase(otherObj)) {
                app.remove(i); // remove the person from the list
                return true;
            }            
        }

        // if nothing is found in the for loop, then we will return false
        return false;
    }
            
    // method to search the arrayList obj checking if the user is already entered
    public boolean search(String first, String last) {
        //your code
        for (int i=0; i<app.size(); i++) {
            // concatenate the name
            String checkName = first + " " + last;

            //  a string for the objects already in the array/list
            String objectName = app.get(i).getFirst() + " " + app.get(i).getLast();
            if (checkName.equalsIgnoreCase(objectName)) {
                return true;
            }
        }
        return false; // must change
    }
        
    // method to return the Array object or the List object
    public ArrayList<User> getList() {
        return app;
    }

    // method returns the size of the ArayList app; represents the number of followers
    public int followerCounts() {
        return this.app.size();
    }
    // method that returns the number of people this specific person is following
    public int followingCounts() {
        int  i=0; // variable to store the total number of people thi person is following
        for (int j=0; j < app.size(); j++) {
            // if the follow variable is true then increment by 1
            if (app.get(j).getFollow()) {
                i++;
            }
        }
        return i;
    } 

    // OBJECT REPRESENTATION; 
    public String toString() {
        String s = "";
        // returns a string representing all the followers in the list
        
        for (int i=0; i < app.size(); i++) {
            s += app.get(i).toString() + "\n";
            s += "************************\n";
        }
        return s;

    }
}


public class InstaLastName {
    
}