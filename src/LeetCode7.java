/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode7 {
    public static void main(String[] args) {
        LeetCode7 leetCode7 = new LeetCode7();
        System.out.println(leetCode7.reverse(-1534236461));
    }

    public int reverse(int x) {
        int BASE_ARRAY_LENGTH = 10;
        int[] reverseArray = new int[BASE_ARRAY_LENGTH];
        int curIndex = 0;
        boolean isXPositive = false;
        if (x < 0) {
            if (Integer.MIN_VALUE == x) {
                return 0;
            } else {
                x = -x;
            }
        } else {
            isXPositive = true;
        }
        while (x >= 10) {
            if (curIndex >= reverseArray.length) {
                int[] temp = reverseArray;
                reverseArray = new int[reverseArray.length + BASE_ARRAY_LENGTH];
                System.arraycopy(temp, 0, reverseArray, 0, temp.length);
            }
            reverseArray[curIndex++] = x % 10;
            x = x / 10;
        }
        reverseArray[curIndex] = x;
        int result = 0;
        for (int i = 0; i <= curIndex; i++) {
            int powValue = pow(10, curIndex - i);
            if (powValue == Integer.MAX_VALUE) {
                return 0;
            }
            if (Integer.MAX_VALUE / powValue < reverseArray[i]) {
                return 0;
            }
            int increaseValue = reverseArray[i] * powValue;
            if (Integer.MAX_VALUE - result < increaseValue) {
                return 0;
            }
            result += increaseValue;
        }
        if (!isXPositive) {
            return -result;
        }
        return result;
    }

    private int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (result > Integer.MAX_VALUE / a) {
                return Integer.MAX_VALUE;
            }
            result *= a;
        }
        return result;
    }
}