package array;

public class LeetCode724 {
    public static void main(String[] args) {
        LeetCode724 leetCode724 = new LeetCode724();
        System.out.println(leetCode724.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    private int leftSum(int[] nums, int index) {
        if (index == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = leftSum(nums, i);
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
