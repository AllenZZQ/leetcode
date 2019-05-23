package binarysearch;

import junit.framework.TestCase;
import util.Optimal;


public class P4 extends TestCase {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) nums1 = new int[0];
        if (nums2 == null) nums2 = new int[0];

        int i1 = (nums1.length + nums2.length + 1) / 2 - 1;
        int x1 = 0, x2 = 0, m1 = 0, m2 = 0;
        while (x1 < nums1.length && x2 < nums2.length && x1 + x2 <= i1 + 1) {
            int y1 = nums1[x1];
            int y2 = nums2[x2];
            if (x1 + x2 == i1) {
                m1 = Math.min(y1, y2);
            }
            if (x1 + x2 == i1 + 1) {
                m2 = Math.min(y1, y2);
            }
            if (y1 < y2) {
                x1 ++;
            } else {
                x2 ++;
            }
        }
        while (x1 < nums1.length && x1 + x2 <= i1 + 1) {
            if (x1 + x2 == i1) {
                m1 = nums1[x1];
            }
            if (x1 + x2 == i1 + 1) {
                m2 = nums1[x1];
            }
            x1 ++;
        }
        while (x2 < nums2.length && x1 + x2 <= i1 + 1) {
            if (x1 + x2 == i1) {
                m1 = nums2[x2];
            }
            if (x1 + x2 == i1 + 1) {
                m2 = nums2[x2];
            }
            x2 ++;
        }
        if (isOdd(nums1.length + nums2.length)) {
            return m1;
        }
        return (m1 + m2) / 2.0;
    }

    /**
     * 二分查找，确立i和j的关系，j = (m + n + 1) / 2 - i，利用中位数的性质二分查找i的位置
     * @param nums1
     * @param nums2
     * @return
     */
    @Optimal
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null) nums1 = new int[0];
        if (nums2 == null) nums2 = new int[0];
        if (nums1.length == 0 && nums2.length == 0) return 0;
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int iMin = 0, iMax = nums1.length, halfLen = (nums1.length + nums2.length + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums2[j] < nums1[i - 1]) {
                iMax = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if (isOdd(nums1.length + nums2.length)) {
                    return maxLeft;
                }

                int minRight;
                if (i == nums1.length) {
                    minRight = nums2[j];
                } else if (j == nums2.length) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }

    private boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

}
