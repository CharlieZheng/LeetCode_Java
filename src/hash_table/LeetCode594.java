package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode594 {
    public static void main(String[] args) {
        LeetCode594 leetCode594 = new LeetCode594();
//        [1, 3, 5, 7, 9, 11, 13, 15, 17]
        System.out.println(leetCode594.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> cntArray = new ArrayList<>();
        List<Integer> valueArray = new ArrayList<>();
        int cur = nums[0];
        int curCnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                curCnt++;
            } else {
                valueArray.add(cur);
                cntArray.add(curCnt);
                cur = nums[i];
                curCnt = 1;
            }
        }
        cntArray.add(curCnt);
        valueArray.add(cur);
        if (cntArray.size() <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < cntArray.size() - 1; i++) {
            if (Math.abs(valueArray.get(i) - valueArray.get(i + 1)) == 1) {
                if (max < cntArray.get(i) + cntArray.get(i + 1)) {
                    max = cntArray.get(i) + cntArray.get(i + 1);
                }
            }
        }
        return max;
    }
}
