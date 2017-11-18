package array;

import java.util.Arrays;

public class LeetCode268 {
    public static void main(String[] args) {
        LeetCode268 leetCode268 = new LeetCode268();
       System.out.println( leetCode268.missingNumber(new int[]{0}));
    }

    public int missingNumber(int[] nums) {
     Arrays.sort(nums);
        int i =0;
        for ( i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return i;
    }
}
