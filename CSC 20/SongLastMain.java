public class SongLastMain {
    public static final int JUICE_BOTTLES = 10;
    public static void main(String[] args) {
        lyrics();
    }

    public static void lyrics() {
        // write for loop to iterate through juice bottles
        for (int i=JUICE_BOTTLES; i>1;i--) {

            // print "X bottles of the Juice on the wall, X bottles of juice"
            System.out.printf("%d bottles of the Juice on the wall, %d bottles of juice.\n", i, i);
            // print "Take one down and pass it around"
            System.out.printf("Take one down and pass it around, %d bottles of juice on the wall.\n", i - 1);
        
        }
        // print the last 3 statements
        System.out.println("1 bottle of the juice on the wall, 1 bottle of the juice");
        System.out.println("Take one down and pass it around, no more bottles of juice on the wall.");
        System.out.printf("Go to the store and buy some more, %d bottles of juice on the wall.\n", JUICE_BOTTLES-1);
    }
}
