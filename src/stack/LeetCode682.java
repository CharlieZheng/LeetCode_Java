package stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode682 {
    public static void main(String[] args) {
        LeetCode682 leetCode682 = new LeetCode682();
        System.out.println(leetCode682.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public int calPoints(String[] ops) {
        List<Integer> lastScore = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    if (lastScore.size() > 0) {
                        sum -= lastScore.get(lastScore.size() - 1);
                        lastScore.remove(lastScore.size() - 1);
                    }
                    break;
                case "D":
                    if (lastScore.size() > 0) {
                        lastScore.add(lastScore.get(lastScore.size() - 1) * 2);
                        sum += lastScore.get(lastScore.size() - 1);
                    }
                    break;
                case "+":
                    if (lastScore.size() > 1) {
                        lastScore.add(lastScore.get(lastScore.size() - 2) + lastScore.get(lastScore.size() - 1));
                        sum += lastScore.get(lastScore.size() - 1);
                    }
                    break;
                default:
                    try {
                        lastScore.add(Integer.valueOf(ops[i]));
                        sum += lastScore.get(lastScore.size() - 1);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return sum;
    }
}
