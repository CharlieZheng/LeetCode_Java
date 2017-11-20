package string;

import java.util.Arrays;

public class LeetCode383 {
    public static void main(String[] args) {
        LeetCode383 leetCode383 = new LeetCode383();
        System.out.println(leetCode383.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || (ransomNote != null && ransomNote.length() > magazine.length())) {
            return false;
        }
        char[] cA1 = ransomNote.toCharArray();
        char[] cA2 = magazine.toCharArray();
        Arrays.sort(cA1);
        Arrays.sort(cA2);
        boolean[] foundArray = new boolean[ransomNote.length()];
        int foundIndex = 0;
        for (int i = 0; i < ransomNote.length(); i++) {
            for (int j = foundIndex; j < magazine.length(); j++) {
                if (cA1[i] == cA2[j]) {
                    foundArray[i] = true;
                    foundIndex = j + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < foundArray.length; i++) {
            if (!foundArray[i]) {
                return false;
            }
        }
        return true;
    }
}
