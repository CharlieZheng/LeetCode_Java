package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438 {
    public static void main(String[] args) {
        LeetCode438 leetCode438 = new LeetCode438();
        List<Integer> integerList = leetCode438.findAnagrams("aa", "ab");
        for (Integer item : integerList) {
            System.out.print(item + "\t");
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> integerList = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            char[] sSubArray = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(sSubArray);
            boolean ok = true;
            for (int j = 0; j < p.length(); j++) {
                if (sSubArray[j] != pArray[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) integerList.add(i);
        }
        return integerList;
    }
}
