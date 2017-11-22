package array;

public class LeetCode27 {
    public static void main(String[] args) {
        LeetCode27 leetCode27 = new LeetCode27();
        System.out.println(leetCode27.removeElement(new int[]{1, 1}, 1));
    }

    public int removeElement(int[] nums, int val) {
        int replaceIndex = nums.length - 1;
        int temp;
        int times = 0;
        for (int i = 0; i < nums.length && i < replaceIndex; i++) {
            if (nums[i] == val) {
                while (nums[replaceIndex] == val) {
                    replaceIndex--;
                    if (replaceIndex < 0) {
                        break;
                    }
                }
                if (replaceIndex < 0) {
                    break;
                }
                times++;
                temp = nums[replaceIndex];
                nums[replaceIndex--] = nums[i];
                nums[i] = temp;
            }
        }
        return nums.length - times;
    }
}
