package array;

public class ACYetLeetCode27 {
    public static void main(String[] args) {
        ACYetLeetCode27 ACYetLeetCode27 = new ACYetLeetCode27();
        for (int i : ACYetLeetCode27.removeElement(new int[]{3, 2, 2, 3, 4, 3}, 3)) {
            System.out.print(i + "\t");
        }
    }

    public int[] removeElement(int[] nums, int val) {
        int offset = 1;
        int length = nums.length;
        for (int i = 0; i + offset < nums.length - 1; i++) {
            if (nums[i] == val) {
                nums[i] = nums[length - offset];
                offset++;
            }
        }
        return nums;
    }
}
