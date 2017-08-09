package array;

public class ACYetLeetCode88 {
    public static void main(String[] args) {
        ACYetLeetCode88 acYetLeetCode88 = new ACYetLeetCode88();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        acYetLeetCode88.merge(nums1, 0, nums2, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1;
        int[] nums = new int[m + n];
        for (int i = m + n - 1; i >= 0; i--) {
            if (i2 >= 0 && i1 >= 0 && nums2[i2] > nums1[i1]) {
                nums[i] = nums2[i2--];
            } else if (i1 >= 0) {
                nums[i] = nums1[i1--];
            }
        }
        for (int i : nums) {
            System.out.println(i + "\t");
        }

    }
}
