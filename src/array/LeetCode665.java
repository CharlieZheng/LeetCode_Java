package array;

import java.util.Arrays;

public class LeetCode665 {
    public static void main(String[] args) {
        LeetCode665 leetCode665 = new LeetCode665();
        System.out.println(leetCode665.checkPossibility(new int[]{1, 8, 2, 3}));
    }

    public boolean checkPossibility(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;
        int lastValue = nums[0];
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (lastValue <= nums[i]) {
                lastValue = nums[i];
            } else {
                cnt++;
                if (i == 1) {
                    lastValue = nums[i];
                }
            }
        }
        return cnt <= 1;
    }
}
