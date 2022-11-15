package Tokenizer;

public class Main {
    public static void main(String[] args) {
        String raw = "This is a test of a string tokenizer!";
        Tokenizer t = new Tokenizer(raw, ' ');
        while (t.hasMoreTokens()) {
            System.out.println(t.nextToken());
        }
    }

    public static int getBit(int value, int bitNum) {
        int shift = 1 << bitNum;
        int ret = value & shift;
        ret = ret >> bitNum;
        return ret;
    }

    public static int getBit2(int value, int bitNum) {
        return (value & (1 << bitNum) >> bitNum);
    }
}
