package array;

import stack.LeetCode682;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode697 {
    public static void main(String[] args) {
        LeetCode697 leetCode697 = new LeetCode697();
        System.out.println(leetCode697.findShortestSubArray(new int[]{3, 4, 3, 2, 1, 5, 5}));
    }

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        int[] numsTemp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsTemp[i] = nums[i];
        }
        Arrays.sort(numsTemp);
        int max = 0;
        int curMax = 0;
        List<Integer> maxInt = new ArrayList<>();
        int index;
        for (index = 0; index < numsTemp.length - 1; index++) {
            if (numsTemp[index] == numsTemp[index + 1]) {
                curMax++;
                if (index == numsTemp.length - 2) {
                    curMax++;
                    if (max <= curMax) {
                        if (max < curMax)
                            maxInt.clear();
                        maxInt.add(numsTemp[index]);
                        max = curMax;
                    }
                }
            } else {
                curMax++;
                if (max <= curMax) {
                    if (max < curMax)
                        maxInt.clear();
                    maxInt.add(numsTemp[index]);
                    max = curMax;
                }
                curMax = 0;
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (Integer item : maxInt) {
            int startIndex = 0, endIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (item == nums[i]) {
                    startIndex = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (item == nums[i]) {
                    endIndex = i;
                    break;
                }
            }
            if (startIndex < endIndex && shortest > endIndex - startIndex + 1) {
                shortest = endIndex - startIndex + 1;
            }
        }
        if (shortest == Integer.MAX_VALUE) return 1;
        return shortest;
    }
}
