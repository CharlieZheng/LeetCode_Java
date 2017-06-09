/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode14 {
    public static void main(String[] args) {
        LeetCode14 leetCode14 = new LeetCode14();
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"aca", "cba"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String common = "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        for (int j = 0; j < minLength; j++) {
            char firstCurChar = strs[0].charAt(j);
            int equalCount = 0;
            for (int i = 1; i < strs.length; i++) {
                String item = strs[i];
                char otherCurChar = item.charAt(j);
                if (firstCurChar != otherCurChar) {
                    break;
                } else {
                    equalCount++;
                }
            }
            if (equalCount == strs.length - 1) {
                common += String.valueOf(firstCurChar);
            } else {
                break;
            }
        }
        return common;
    }
}