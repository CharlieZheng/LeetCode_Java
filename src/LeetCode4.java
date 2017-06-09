/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode4 {
    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1, 2, 3, 4};
        leetCode4.findMedianSortedArrays2(num1, num2);
    }

    /**
     * 超出限制时间
     * 思路：构造新的数组
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int z = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                if (j < nums2.length) {
                    result[z++] = nums2[j++];
                    continue;
                } else {
                    break;
                }
            }
            if (j == nums2.length) {
                if (i < nums1.length) {
                    result[z++] = nums1[i++];
                    continue;
                } else {
                    break;
                }
            }
            if (nums1[i] < nums2[j]) {
                result[z++] = nums1[i++];
            } else {
                result[z++] = nums2[j++];
            }
        }
        double res = 0;
        if (result.length % 2 == 0) {
            res = (result[result.length / 2] + result[result.length / 2 - 1]) / 2f;
        } else {
            res = result[result.length / 2];
        }
        return res;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int end = (nums1.length + nums2.length) / 2;
        boolean shuang = (nums1.length + nums2.length) % 2 == 0;
        if (end == 0) {
            shuang = false;
        }
        int i = 0, j = 0;
        int z = 0;
        double left = 0, right = 0, mid = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {

                if (z == end - 1 && shuang) {
                    left = nums2[j++];
                    z++;
                    continue;
                }
                if (z == end && shuang) {
                    right = nums2[j];

                    break;
                }
                if (z == end) {
                    mid = nums2[j];

                    break;
                }
                j++;
                z++;
                continue;

            }
            if (j >= nums2.length) {

                if (z == end - 1 && shuang) {
                    left = nums1[i++];
                    z++;
                    continue;
                }
                if (z == end && shuang) {
                    right = nums1[i];

                    break;
                }
                if (z == end) {
                    mid = nums1[i];

                    break;
                }
                i++;
                z++;
                continue;
            }

            if (nums1[i] < nums2[j]) {
                if (z == end - 1 && shuang) {
                    left = nums1[i++];
                    z++;
                    continue;
                }
                if (z == end && shuang) {
                    right = nums1[i];

                    break;
                }
                if (z == end) {
                    mid = nums1[i];

                    break;
                }
                i++;
                z++;
            } else {
                if (z == end - 1 && shuang) {
                    left = nums2[j++];
                    z++;
                    continue;
                }
                if (z == end && shuang) {
                    right = nums2[j];

                    break;
                }
                if (z == end) {
                    mid = nums2[j];

                    break;
                }
                j++;
                z++;
            }

        }
        if (shuang) {
            return (left + right) / 2f;
        } else {
            return mid / 2f;
        }
    }
}
