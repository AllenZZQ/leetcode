package array;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

/**
 * 这题理解了什么是nextPermutation，题目不难
 *
 * 1.从后往前遍历，找到第一个降序的数字，a
 * 2.从后往前遍历，找到第一个比a大的数字，b
 * 3.交换a，b
 * 4.将b后面的数字翻转
 *
 */

public class P31 extends TestCase {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i --;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1]) {
                j --;
            }
            int temp = nums[i - 1];
            nums[i- 1] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        for (int i = begin, j = end; i < j; i ++, j --) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public void test() {
        int[] nums = new int[]{1, 2, 3, 3};
        nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
