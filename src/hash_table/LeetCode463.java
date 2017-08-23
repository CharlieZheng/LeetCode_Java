package hash_table;

public class LeetCode463 {
    public static void main(String[] args) {
        LeetCode463 leetCode463 = new LeetCode463();
        int[][] grid = new int[][]{{1, 0, 1},
                {1, 0, 1}, {1, 0, 1}};
        System.out.println(leetCode463.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                int item = row[j];
                if (item == 1) {
                    int temp = itemSlideCount(grid, i, j);
                    if (temp > 0) {
                        sum += 4 - temp;
                    }
                }
            }
        }
        return sum;
    }

    private int itemSlideCount(int[][] grid, int i, int j) {
        int l = 0, t = 0, r = 0, b = 0;
        if (i - 1 >= 0) {
            t = grid[i - 1][j];
        }
        if (i + 1 < grid.length) {
            b = grid[i + 1][j];
        }
        if (j - 1 >= 0) {
            l = grid[i][j - 1];
        }
        if (j + 1 < grid[0].length) {
            r = grid[i][j + 1];
        }
        return l + t + r + b;
    }
}
