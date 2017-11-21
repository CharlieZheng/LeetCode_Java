package array;

public class LeetCode674 {
    public static void main(String[] args) {
        LeetCode674 leetCode674 = new LeetCode674();
        System.out.println(leetCode674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int lastSum = 1;
        int[] sumArray = new int[nums.length];
        int sumArrayIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                lastSum++;
            } else {
                sumArray[sumArrayIndex++] = lastSum;
                lastSum = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (lastSum < sumArray[i]) {
                lastSum = sumArray[i];
            }
        }
        return lastSum;
    }
}
