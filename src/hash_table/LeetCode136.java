package hash_table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode136 {
    public static void main(String[] args) {
        LeetCode136 leetCode136 = new LeetCode136();
        System.out.println(leetCode136.singleNumber(new int[]{1, 2, 2, 1, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length - 1; ) {
            if (nums[i] == nums[i + 1]) {
                i = i + 2;
            } else {
                return nums[i];
            }
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        return 0;
    }
}
