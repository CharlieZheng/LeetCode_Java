public class LeetCode504 {
    public static void main(String[] args) {
        LeetCode504 leetCode504 = new LeetCode504();
        System.out.println(leetCode504.convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        boolean negative = num < 0;
        num = Math.abs(num);
        String rs = (num % 7) + "";
        while ((num = num / 7) != 0) {
            rs += (num % 7) + "";
        }
        char[] rsArray = rs.toCharArray();
        for (int i = 0; i < rs.length(); i++) {
            rsArray[i] = rs.charAt(rs.length() - 1 - i);
        }
        rs = new String(rsArray);
        if (negative) {
            rs = "-" + rs;
        }
        return rs;
    }
}
