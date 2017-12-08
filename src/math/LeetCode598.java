package math;

public class LeetCode598 {
    public static void main(String[] args) {
        LeetCode598 leetCode598 = new LeetCode598();
        System.out.println(leetCode598.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}, {1, 2}}));
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length <= 0) return m * n;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < minX) {
                minX = ops[i][0];
            }
            if (ops[i][1] < minY) {
                minY = ops[i][1];
            }
        }
        return minX * minY;
    }
}
