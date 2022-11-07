package HashMaps;

public class Hash {

    // Fields
    private final int M = 8; // Size of array
    private HashChain[] map;
    private int n; // How many key,value pairs in map

    // Constructor
    public Hash() {

        map = new HashChain[M];

        for (int i = 0; i < M; i++)

            map[i] = new HashChain(); // Initialize

        n = 0;

    }

    // Methods

    private int hash(String key) {

        final int R = 31;

        int h = 0;

        for (int i = 0; i < key.length(); i++)

            h = ((R * h) + key.charAt(i)) % M; // Text recommends 31 as 'R'

        return h;

    }

    public String getValue(String key) {

        int e = hash(key);

        return map[e].getValue(key);

    }

    public void put(String key, String value) {

        int e = hash(key);

        if (map[e].addNode(key, value))

            n++;

    }

    public void delete(String key) {

        int e = hash(key);

        if (map[e].removeNode(key))

            n--;

    }

    public boolean isEmpty() {

        return n == 0;

    }

    public int size() {

        return n;

    }

    public void clear() {

        for (int i = 0; i < M; i++)

            map[i].clear();

        n = 0;

    }

    public String toString() {

        String ret = "";

        for (int i = 0; i < M; i++)

            ret += map[i].toString() + "\n";

        return ret;

    }

}
