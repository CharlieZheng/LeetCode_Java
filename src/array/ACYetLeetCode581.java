package array;

public class ACYetLeetCode581 {
    public static void main(String[] args) {
        ACYetLeetCode581 ACYetLeetCode581 = new ACYetLeetCode581();
        int[] nums = new int[]{1, 2, 5, 6, 4};
        System.out.println(ACYetLeetCode581.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int lastNum = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < length; i++) {
            int numIndex = nums[i];
            if (numIndex >= lastNum) {
                lastNum = numIndex;
                continue;
            } else {
                pre = i - 1;
                break;
            }
        }
        lastNum = Integer.MAX_VALUE;
        int suf = 0;
        for (int i = length - 1; i >= 0; i--) {
            int numIndex = nums[i];
            if (numIndex <= lastNum) {
                lastNum = numIndex;
                continue;
            } else {
                suf = i + 1;
                break;
            }
        }

        if (yes(nums, pre, suf)) {
            return result(length, pre, suf);
        } else {
            if (nums[pre] > nums[suf]) {
                if (yes(nums, --pre, suf)) {
                    return result(length, pre, suf);
                }
            } else {
                if (yes(nums, pre, ++suf)) {
                    return result(length, pre, suf);
                }
            }
        }
        for (int i : nums) {
            if (nums[0] >= i && nums[length - 1] <= i) {
                return length;
            }
        }

        return length - 1;
    }

    private boolean yes(int[] nums, int pre, int suf) {
        for (int i = pre + 1; i < suf; i++) {
            int min = nums[pre];
            int base = nums[i];
            int max = nums[suf];
            if (base < min || base > max) {
                return false;
            }
        }
        if (nums[pre] > nums[suf]) {
            return false;
        }
        return true;
    }

    private int result(int length, int pre, int suf) {
        if (pre >= suf) {
            return 0;
        }
        return length - (pre + 1) - (length - suf);
    }
}
