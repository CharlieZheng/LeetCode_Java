package array;

public class LeetCode717 {
    public static void main(String[] args) {
        LeetCode717 leetCode717 = new LeetCode717();
        System.out.println(leetCode717.isOneBitCharacter(new int[]{1}));
    }

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null) return false;
        if (bits.length == 0) return true;
        if (bits[bits.length - 1] == 1) return false;
        else if (bits.length == 1 || bits[bits.length - 2] == 0) return true;
        else {
            for (int i = 0; i < bits.length; ) {
                if (bits[i] == 1) {
                    if (i == bits.length - 2) return false;
                    i += 2;
                } else {
                    if (i == bits.length - 1) return true;
                    i += 1;
                }
            }
            return false;
        }
    }
}
