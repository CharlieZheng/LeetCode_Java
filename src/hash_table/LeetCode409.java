package hash_table;

public class LeetCode409 {
    private class Node {
        private char name;
        private int cnt;

        public Node(char name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    public int longestPalindrome(String s) {
        Node[] nodes = new Node[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (nodes[j].name == s.charAt(i)) {
                    found = true;
                    nodes[j].cnt++;
                    break;
                }
            }
            if (!found) {
                nodes[index++] = new Node(s.charAt(i), 1);
            }
        }
        boolean hasOdd = false;
        int sum = 0;
        for (int i = 0; i < index; i++) {
            if (nodes[i].cnt % 2 != 0) {
                hasOdd = true;
            }
            sum += nodes[i].cnt / 2 * 2;
        }
        if (hasOdd) {
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode409 leetCode409 = new LeetCode409();
        System.out.println(leetCode409.longestPalindrome("abccccdd"));
    }
}
