package HashMaps;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // For the API...

        HashMap<String, String> map = new HashMap<>();

        map.put("Tester", "Hello!");

        map.put("Testy", "Howdy!");

        map.put("Test", "Hola!");

        System.out.println(map.toString());

        System.out.println("Deleting Tester...");

        map.remove("Tester");

        System.out.println(map.toString());

        System.out.println("Clearing the map...");

        map.clear();

        System.out.println(map.toString());
    }
}
