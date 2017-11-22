package hash_table;

import java.util.ArrayList;
import java.util.List;

public class LeetCode594 {
    public static void main(String[] args) {
        LeetCode594 leetCode594 = new LeetCode594();
        System.out.println(leetCode594.findLHS(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2}));
    }

    public int findLHS(int[] nums) {
        List<List<Integer>> remember = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean handle = false;
            for (int j = 0; j < remember.size(); j++) {
                boolean harmonious = true;
                List<Integer> rememberItem = remember.get(j);
                for (int z = 0; z < rememberItem.size(); z++) {
                    int item = rememberItem.get(z);
                    if ((item - nums[i]) > 1 || nums[i] - item > 1) {
                        harmonious = false;
                        break;
                    }
                }
                if (harmonious) {
                    handle = true;
                    rememberItem.add(nums[i]);
                }
            }
            if (!handle) {
                List<Integer> newRememberItem = new ArrayList<>();
                newRememberItem.add(nums[i]);
                remember.add(newRememberItem);
            }
        }
        int maxSize = 0;
        for (int i = 0; i < remember.size(); i++) {
            List<Integer> temp = remember.get(i);
            int length = temp.size();
            int sum = 0;
            for (int j = 0; j < length; j++) {
                sum += temp.get(j);
            }
            if (sum % length != 0 && maxSize < length)
                maxSize = length;
        }
        return maxSize;
    }
}
