package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LeetCode575 {
    public static void main(String[] args) {
        LeetCode575 leetCode575 = new LeetCode575();
        System.out.println(leetCode575.distributeCandies(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3}));
    }

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        List<Integer> kindList = new ArrayList<>();
        int lastKind = -1;
        for (int i = 0; i < candies.length; i++) {
            if (lastKind != candies[i]) {
                lastKind = candies[i];
                kindList.add(candies[i]);
            }
        }
        if (candies.length / 2 > kindList.size()) {
            return kindList.size();
        } else {
            return candies.length / 2;
        }
    }
}
