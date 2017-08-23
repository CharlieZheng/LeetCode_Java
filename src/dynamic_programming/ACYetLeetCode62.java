package dynamic_programming;

public class ACYetLeetCode62 {
    public static void main(String[] args) {
        ACYetLeetCode62 acYetLeetCode62 = new ACYetLeetCode62();
        System.out.println(acYetLeetCode62.uniquePaths(23, 12));
    }

    public int uniquePaths(int m, int n) {
        int[][] p = new int[m][n];
        for (int i = 0; i < m;i++){
            p[i][0] =1;
        }
        for (int j =0;j<n;j++) {
            p[0][j]=0;
        }
        for (int i=1; i < m;i++){

        }
        return 0;
    }
}
