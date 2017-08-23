package string;

public class LeetCode657 {
    public static void main(String[] args) {
        LeetCode657 leetCode657 = new LeetCode657();
        System.out.println(leetCode657.judgeCircle("LURD"));
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) return false;
        int horizontal = 0, vertical = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    horizontal--;
                    break;
                case 'U':
                    vertical--;
                    break;
                case 'R':
                    horizontal++;
                    break;
                case 'D':
                    vertical++;
                    break;
            }
        }
        return horizontal == 0 && vertical == 0;
    }
}
