package string;

public class LeetCode551 {
    public static void main(String[] args) {
        LeetCode551 leetCode551 = new LeetCode551();
        System.out.println(leetCode551.checkRecord("LLLALL"));
    }

    public boolean checkRecord(String s) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                cnt1++;
                if (cnt1 > 1) {
                    return false;
                }
            }
            if (s.charAt(i) == 'L') {
                if ((i > 0 && s.charAt(i - 1) == 'L' || i == 0)) {
                    cnt2++;
                    if (cnt2 > 2) {
                        return false;
                    }
                } else if (s.charAt(i - 1) != 'L') {
                    cnt2 = 1;
                }
            }
        }
        return !(cnt1 > 1 || cnt2 > 2);
    }
}
