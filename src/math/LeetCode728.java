package math;

import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {
    public static void main(String[] args) {
        LeetCode728 leetCode728 = new LeetCode728();
        List<Integer> selfDividingNumbers = leetCode728.selfDividingNumbers(1, 22);
        for (int i = 0; i < selfDividingNumbers.size(); i++) {
            System.out.print(selfDividingNumbers.get(i) + "\t");
        }
        System.out.println();
    }

    private boolean selfDividing(int number) {
        int originalNumber = number;
        while (number > 0) {
            int temp = number % 10;
            if (temp == 0 || originalNumber % temp != 0) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDividing(i)) {
                resultList.add(i);
            }
        }
        return resultList;
    }
}
