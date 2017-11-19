package dynamic_programming;

public class LeetCode53 {
    public static void main(String[] args) {
        LeetCode53 leetCode5 = new LeetCode53();
        System.out.println(leetCode5.maxSubArray(new int[]{2, -3, 5}));
        System.out.println(leetCode5.maxSubArray(new int[]{-3, -2}));
    }

    public int maxSubArray(int[] nums) {
        int c[] = new int[nums.length];
        c[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            c[i] = Math.max(c[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < c.length; i++) {
            if (max < c[i]) {
                max = c[i];
            }
        }
        return max;
    }
}
