package dynamic_programming;

public class LeetCode303 {

    private int[] sum;

    public LeetCode303(int[] nums) {
        if (nums.length == 0) return;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null) return 0;
        if (i <= 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }
}
