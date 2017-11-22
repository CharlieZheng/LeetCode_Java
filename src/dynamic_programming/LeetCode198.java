package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode198 {
    public static void main(String[] args) {
        LeetCode198 leetCode198 = new LeetCode198();
        System.out.println(leetCode198.rob(new int[]{8, 5, 6, 7, 4, 0, 9, 8}));
//                   打劫     不打劫      在该区间中打劫能获取的最大收益
//   [8]             8       0;          8
//   [8, 5]          5       8;          8
//   [8, 5, 6]       14      8;          14
//   [8, 5, 6, 7]    15      14;         15
//   ...
//   ...
//   结论：区间[0, i]的最大收益 = max{i的收益 + 区间[0, i - 2]的最大收益, 区间[0, i - 1]的最大收益}
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];
        maxArray[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            maxArray[i] = Math.max(maxArray[i - 1], maxArray[i - 2] + nums[i]);
        }
        int max = 0;
        for (int i = 0; i < maxArray.length; i++) {
            if (max < maxArray[i]) {
                max = maxArray[i];
            }
        }
        return max;
    }
}
