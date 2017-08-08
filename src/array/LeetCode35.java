package array;

// AC
public class LeetCode35 {
    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] nums = new int[]{1};
        System.out.println(leetCode35.searchInsert(nums, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return i + 1;
    }
}

