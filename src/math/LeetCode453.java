package math;

public class LeetCode453 {
    public static void main(String[] args) {
        LeetCode453 leetCode453 = new LeetCode453();
        System.out.println(leetCode453.minMoves(new int[]{1, 2,3}));
    }
    public int minMoves(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += max - nums[i];
        }
        if (sum % 2 == 0) {
            return sum / 2;
        } else {
            return (sum + length) / 2;
        }

    }
}
