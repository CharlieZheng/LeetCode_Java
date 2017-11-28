package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hanrong on 2017/5/24.
 */
public class LeetCode4 {
    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        int[] num1 = new int[]{4, 2};
        int[] num2 = new int[]{1, 3};
        System.out.println(leetCode4.findMedianSortedArrays(num1, num2));
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

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            a[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            a[i] = nums2[nums1.length + i];
        }
        List aList = Arrays.asList(a);
        Collections.sort(aList);
        int length = nums1.length + nums2.length;
        int mid = length / 2;
        if (length % 2 == 0) {
            return ((Integer) aList.get(mid - 1) + (Integer) aList.get(mid)) / 2f;
        } else {
            return (Integer) aList.get(mid);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList();
        if (nums1 != null)
            for (int i = 0; i < nums1.length; i++)
                nums.add(nums1[i]);
        if (nums2 != null)
            for (int i = 0; i < nums2.length; i++)
                nums.add(nums2[i]);
        Collections.sort(nums);
        if (nums.size() % 2 == 0) {
            return (nums.get(nums.size() / 2 - 1) + nums.get(nums.size() / 2)) / 2f;
        } else {
            return nums.get(nums.size() / 2);
        }
    }
}
