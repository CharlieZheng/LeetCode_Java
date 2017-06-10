/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode8 {
    public static void main(String[] args) {
        LeetCode8 leetCode8 = new LeetCode8();
        System.out.println(leetCode8.myAtoi("2147483648"));
    }

    public int myAtoi(String str) {
        final int BASE_ARRAY_SIZE = 1;
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        while (str.charAt(0) == '0') {
            if (str.length() == 1) {
                return 0;
            }
            str = str.substring(1);
        }
        boolean isResultPositive = true;
        if (str.charAt(0) == '-') {
            isResultPositive = false;
        }
        int[] resultIntArray = new int[BASE_ARRAY_SIZE];
        int resultIntArrayIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            int itemIntValue = item - '0';
            if (i == 0 && (itemIntValue == ('+' - '0') || (itemIntValue == ('-' - '0')))) {
                continue;
            }
            if ((itemIntValue < 0 || itemIntValue > 9)) {
                break;
            }
            if (resultIntArrayIndex >= resultIntArray.length) {
                int[] temp = resultIntArray;
                resultIntArray = new int[resultIntArray.length + BASE_ARRAY_SIZE];
                System.arraycopy(temp, 0, resultIntArray, 0, temp.length);
            }
            resultIntArray[resultIntArrayIndex++] = itemIntValue;
        }
        int result = 0;
        for (int i = 0; i < resultIntArray.length; i++) {
            int powValue = pow(resultIntArray.length - 1 - i);
            if (powValue == 0) {
                if (isResultPositive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            int plusNumber = resultIntArray[i] * powValue;
            if (Integer.MAX_VALUE - result < plusNumber) {
                if (isResultPositive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result += plusNumber;
        }
        if (isResultPositive) {
            return result;
        } else {
            return -result;
        }
    }

    private int pow(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (Integer.MAX_VALUE / 10 < result) {
                return 0;
            }
            result *= 10;
        }
        return result;
    }
}