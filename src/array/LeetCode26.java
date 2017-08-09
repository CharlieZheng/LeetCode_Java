package array;

public class LeetCode26 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 23, 24, 25, 25, 26, 26, 26, 27, 28, 29, 90};
        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println();
        LeetCode26 leetCode26 = new LeetCode26();
        System.out.println(leetCode26.removeDuplicates(nums) + "");
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int lastNum = nums[0];
        int emptyIndex = Integer.MAX_VALUE;
        int same = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastNum) {
                same++;
                if (emptyIndex > i) {
                    emptyIndex = i;
                }
            } else if (emptyIndex < i) {
                nums[emptyIndex++] = nums[i];
                lastNum = nums[i];
            } else {
                lastNum = nums[i];
            }
        }
        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println();
        return nums.length - same;
    }
}
