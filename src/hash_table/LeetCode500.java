package hash_table;

import java.util.Arrays;

public class LeetCode500 {

    public static void main(String[] args) {
        LeetCode500 leetCode500 = new LeetCode500();

        String[] result = leetCode500.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        if (result != null)
            for (String item : result) {
                System.out.print(item + "\t");
            }
    }

    char[] row1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
    char[] row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
    char[] row3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    public String[] findWords(String[] words) {
        String[] result = new String[]{};

        int index = 0;
        for (String item : words) {

            char ch = item.charAt(0);
            char[] whichRow = whichRow(ch);
            boolean in = true;
            for (int i = 1; i < item.length(); i++) {
                if (!in(item.charAt(i), whichRow)) {
                    in = false;
                    break;
                }
            }
            if (!in) continue;
            else {
                if (index >= result.length) {
                    result = Arrays.copyOf(result, index + 1);
                }
                result[index++] = item;
            }
        }
        return result;
    }

    private char[] whichRow(char ch) {
        for (char item : row1) {
            if (ch == item) {
                return row1;
            }
        }
        for (char item : row2) {
            if (ch == item) {
                return row2;
            }
        }
        for (char item : row3) {
            if (ch == item) {
                return row3;
            }
        }
        return null;
    }

    private boolean in(char ch, char[] chs) {
        for (char item : chs) {
            if (ch == item) return true;
        }
        return false;
    }
}
