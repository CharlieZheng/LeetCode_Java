package bit_manipulation;

public class LeetCode693 {
    public static void main(String[] args) {
        LeetCode693 leetCode693 = new LeetCode693();
        System.out.println(leetCode693.hasAlternatingBits(5));
    }

    public boolean hasAlternatingBits(int n) {

        int bit = n % 2;
        while ((n = n / 2) != 0) {
            if (bit == n % 2) {
                return false;
            }
            bit = n % 2;
        }
        return true;
    }
}
