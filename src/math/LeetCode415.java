package math;

public class LeetCode415 {
    public static void main(String[] args) {
        LeetCode415 leetCode415 = new LeetCode415();
        System.out.println(leetCode415.addStrings("1", "9"));
    }

    private String makeUpZero(String string, int zeroLength) {
        for (int i = 0; i < zeroLength; i++) {
            string = '0' + string;
        }
        return string;
    }

    public String addStrings(String num1, String num2) {
        int length1 = num1.length(), length2 = num2.length();
        if (length1 < length2) {
            num1 = makeUpZero(num1, length2 - length1);
        } else {
            num2 = makeUpZero(num2, length1 - length2);
        }
        int length = length1 < length2 ? length2 : length1;
        String temp = "";
        boolean hasCarry = false;
        for (int i = length - 1; i >= 0; i--) {
            int bit = (num1.charAt(i) + num2.charAt(i)) - 48 * 2;
            if (hasCarry) {
                bit += 1;
            }
            if (bit >= 10) {
                temp += bit - 10;
            } else {
                temp += bit;
            }
            hasCarry = bit >= 10;
        }
        if (hasCarry) {
            temp += '1';
        }
        if (length1 > length2) {
            for (int i = length; i < length1; i++) {
                if (hasCarry && i == length) {
                    temp += Integer.valueOf(num1.charAt(i) - 48) + 1;
                } else {
                    temp += Integer.valueOf(num1.charAt(i) - 48);
                }
            }
        } else {
            for (int i = length; i < length2; i++) {
                if (hasCarry && i == length) {
                    temp += Integer.valueOf(num2.charAt(i) - 48) + 1;
                } else {
                    temp += Integer.valueOf(num2.charAt(i) - 48);
                }
            }
        }
        String rs = "";
        for (int i = 0; i < temp.length(); i++) {
            rs += temp.charAt(temp.length() - 1 - i);
        }
        return rs;
    }
}
