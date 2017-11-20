package array;

public class LeetCode11 {
    public static void main(String[] args) {
        LeetCode11 leetCode11 = new LeetCode11();
        System.out.println(leetCode11.maxArea(new int[]{1, 1, 3, 4, 1, 3, 4, 2, 7, 9, 1, 2, 0, 5}));
    }


    public int maxArea(int[] height) {
        int length = height.length;
        int[][] allArea = new int[length][length];
        int max = 0;
        for (int i = 0; i <= length - 1; i++) {
            for (int j = i + 1; j <= length - 1; j++) {
                allArea[i][j] = Math.min(height[i], height[j]) * Math.abs(i - j);
                if (max < allArea[i][j]) {
                    max = allArea[i][j];
                }
            }
        }
        return max;
    }


}
