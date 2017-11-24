package string;

import java.util.ArrayList;
import java.util.List;

public class LeetCode345 {
    public static void main(String[] args) {
        LeetCode345 leetCode345 = new LeetCode345();
        System.out.println(leetCode345.reverseVowels("Aa"));
    }

    public String reverseVowels(String s) {
        char[] vowels = new char[]{'a', 'e', 'i', 'u', 'o', 'A', 'E', 'I', 'U', 'O'};
        List<Character> vowelsInS = new ArrayList<>();
        char[] sArray = s.toCharArray();
        List<Integer> vowelPositions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (sArray[i] == vowels[j]) {
                    vowelsInS.add(sArray[i]);
                    vowelPositions.add(i);
                    break;
                }
            }
        }
        for (int i = 0; i < vowelsInS.size() / 2; i++) {
            char temp = vowelsInS.get(i);
            vowelsInS.set(i, vowelsInS.get(vowelsInS.size() - 1 - i));
            vowelsInS.set(vowelsInS.size() - 1 - i, temp);
        }
        for (int i = 0; i < vowelPositions.size(); i++) {
            sArray[vowelPositions.get(i)] = vowelsInS.get(i);
        }
        return new String(sArray);
    }
}
