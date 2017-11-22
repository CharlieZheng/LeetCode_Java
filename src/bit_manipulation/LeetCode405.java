package bit_manipulation;

import hash_table.LeetCode409;
import math.LeetCode415;

public class LeetCode405 {
    public static void main(String[] args) {
        LeetCode405 leetCode405 = new LeetCode405();
       System.out.println(leetCode405.toHex(-1));
    }
    public String toHex(int num) {
        String binary = "";
        binary += num % 2;
        while ((num = num / 2) != 0) {
            binary += num % 2;
        }
        String temp = binary;
        binary = "";
        for (int i = 0; i < temp.length(); i++) {
            binary += temp.charAt(temp.length() - 1 - i);
        }
        return binary;
    }
}
