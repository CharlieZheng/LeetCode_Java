package dynamic_programming;

public class LeetCode5 {
    public static void main(String[] args) {
        LeetCode5 leetCode5 = new LeetCode5();
        System.out.println(leetCode5.longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        int beginIndex = 0;
        int longestLength = 0;
        int length = s.length();
        boolean[][] f = new boolean[length][length];
        if (length > 0) {
            longestLength = 1;
        }
        for (int i = 0; i < length - 1; i++) {
            f[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1] = true;
                beginIndex = i;
                longestLength = 2;
            }
        }
        if (length - 1 >= 0) f[length - 1][length - 1] = true;
        /*if (length - 2 >= 0 && s.charAt(length - 2) == s.charAt(length - 1)) {
            f[length - 2][length - 1] = true;
        }*/
        for (int subLength = 3; subLength <= length; subLength++) {
            for (int i = 0; i <= length - subLength; i++) {

                int j = i + subLength - 1;
                if (f[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    f[i][j] = true;
                    beginIndex = i;
                    longestLength = subLength;
                }
            }
        }

        if (longestLength > 0) {
            return s.substring(beginIndex, beginIndex + longestLength);
        }
        return "";
    }
}
