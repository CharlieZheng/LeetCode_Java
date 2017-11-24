package dynamic_programming;

public class LeetCode718 {
    public static void main(String[] args) {
        LeetCode718 leetCode718 = new LeetCode718();
        System.out.println(leetCode718.findLength(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                new int[]{1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0}));
    }

    public int findLength(int[] A, int[] B) {
        int[] sumArray = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int BIndex = i;
            int sum = 0, maxSum = 0;
            for (int j = 0; j < A.length; j++) {
                if (B[BIndex] == A[j]) {
                    BIndex++;
                    sum++;
                    if (maxSum < sum) {
                        maxSum = sum;
                    }
                } else {
                    j = j-sum ;
                    BIndex = i;
                    sum = 0;
                }
            }
            sumArray[i] = maxSum;
        }
        int maxSum = 0;
        for (int i = 0; i < sumArray.length; i++) {
            if (maxSum < sumArray[i]) {
                maxSum = sumArray[i];
            }
        }
        return maxSum;
    }
}
