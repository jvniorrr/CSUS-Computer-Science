package HashMaps;

public class HashTest{

    public static void main(String[] args){

           Hash hash = new Hash();

           hash.put("Tester", "Hello!");

           hash.put("Testy", "Howdy!");

           hash.put("Test", "Hola!");

           System.out.println("Value of 'Test' is: " + hash.getValue("Test"));

           hash.delete("Test");

           hash.clear();

           System.out.println("Hash map: " + hash.toString());              // View the Hashmap

           System.out.println(hash.isEmpty());

    }
}
