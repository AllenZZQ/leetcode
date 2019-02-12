package numeric;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class P4 extends TestCase {

    public double solution_1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return getMedian(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return getMedian(nums1);
        }
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i == nums1.length) {
                nums[i + j] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                nums[i + j] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                nums[i + j] = nums1[i];
                i++;
            } else {
                nums[i + j] = nums2[j];
                j++;
            }
        }
        return getMedian(nums);
    }

    private double getMedian(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[(length / 2) - 1] + nums[length / 2]) / 2.0;
        } else {
            return nums[(length - 1) / 2];
        }
    }


    public void test() {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        Assertions.assertThat(solution_1(num1, num2)).isEqualTo(2);
    }


}
