package array;

public class ACYetLeetCode268 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        ACYetLeetCode268 ACYetLeetCode268 = new ACYetLeetCode268();
        System.out.println(ACYetLeetCode268.missingNumber(nums) + "");
    }

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
