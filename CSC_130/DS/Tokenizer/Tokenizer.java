package Tokenizer;

import java.util.LinkedList;
import java.util.Queue;

public class Tokenizer {
    private Queue<String> q;

    // constructor
    public Tokenizer(String raw, char delimeter) {
        q = new LinkedList<>();
        init(raw, delimeter);   
    }

    // methods

    /* This is initialization workhorse method (parse the raw string into tokens) */
    private void init(String raw, char delimeter) {
        int cursor = 0;
        int i;
        for (i=0; i<raw.length(); i++) {
            if (raw.charAt(i) == delimeter) {
                // prevent empty tokens (such as delimiter at beginning of string)
                if (cursor == i) {
                    cursor = i + 1;
                    continue;
                }
                String token = raw.substring(cursor, i); // substring end index is EXCLUSIVE
                q.add(token);
                cursor = i + 1;
            }
        }
        // Handle case where the raw string doesn't end on a delimiter and gather final token
        if (raw.charAt(raw.length() - 1) != delimiter) {
            String token = raw.substring(cursor, raw.length()); // substring end index is EXCLUSIVE
            q.add(token);
        }
    }

    public boolean hasMoreTokens() {
        return !q.isEmpty();
    }
    public String nextToken() {
        return q.remove();
    }
    public int countTokens() {
        return q.size();
    }

}
