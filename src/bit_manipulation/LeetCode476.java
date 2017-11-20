package bit_manipulation;

public class LeetCode476 {
    public static void main(String[] args) {
        LeetCode476 leetCode476 = new LeetCode476();
        System.out.println(leetCode476.findComplement(5));
    }

    public int findComplement(int num) {

        String temp = num % 2 + "";
        while ((num = num / 2) != 0) {
            temp += num % 2;
        }
        int sum = 0;
        for (int i = 0; i < temp.length(); i++) {
            int bit = (temp.charAt(temp.length() - 1 - i) - 48);
            if (bit == 0) {
                bit = 1;
            } else {
                bit = 0;
            }
            sum += bit * Math.pow(2, temp.length() - 1 - i);
        }

        return sum;
    }
}
