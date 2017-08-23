package array;

import java.util.Arrays;

public class LeetCode561 {
    public static void main(String[] args) {
        LeetCode561 leetCode561 = new LeetCode561();
        System.out.println(leetCode561.arrayPairSum(new int[]{}));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
