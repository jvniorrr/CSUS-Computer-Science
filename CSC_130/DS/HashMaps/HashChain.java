package HashMaps;

import java.util.LinkedList;

public class HashChain {

    // Fields

    private LinkedList<Node> chain;

    private class Node {

        String key;

        String value;

        public Node(String key, String value) {

            this.key = key;

            this.value = value;

        }

    }

    // Constructor

    public HashChain() {

        chain = new LinkedList<Node>();

    }

    // Methods

    public boolean addNode(String key, String value) {

        if (contains(key))

            return false; // Do not add duplicate key!

        // (We could also choose to replace existing key)

        Node node = new Node(key, value);

        chain.add(node);

        return true;

    }

    public boolean contains(String key) {

        for (int i = 0; i < chain.size(); i++)

            if (chain.get(i).key.equals(key))

                return true;

        return false;

    }

    public String getValue(String key) {

        for (int i = 0; i < chain.size(); i++)

            if (chain.get(i).key.equals(key))

                return chain.get(i).value;

        return null;

    }

    public boolean removeNode(String key) {

        for (int i = 0; i < chain.size(); i++)

            if (chain.get(i).key.equals(key)) {

                chain.remove(i);

                return true;

            }

        return false;

    }

    public void clear() {

        chain.clear();

    }

    public String toString() {

        String ret = "[";

        for (int i = 0; i < chain.size(); i++)

            ret += "<" + chain.get(i).key + ", " + chain.get(i).value + ">,";

        if (ret.length() > 1) // Trim trailing comma only if we have an item in here

            ret = ret.substring(0, ret.length() - 1);

        ret += "]";

        return ret;

    }

}