package array;

public class LeetCode566 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2,}, {4, 5}};
        LeetCode566 leetCode566 = new LeetCode566();
        nums = leetCode566.matrixReshape(nums, 1, 3);
        for (int[] i1 : nums) {
            for (int i2 : i1) {
                System.out.println(i2 + "");
            }
        }
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length <= 0) {
            return nums;
        }
        if (r * c > nums.length * nums[0].length) {
            return nums;
        }
        int[] whole = new int[nums.length * nums[0].length];
        int index = 0;
        for (int[] item1 : nums) {
            for (int item2 : item1) {
                whole[index++] = item2;
            }
        }
        index = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = whole[index++];
            }
        }
        return result;
    }
}
