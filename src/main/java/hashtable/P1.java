package hashtable;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import util.Optimal;

import java.util.HashMap;
import java.util.Map;


public class P1 extends TestCase {

    /**
     * 最容易想到的
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> number2index = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            // 当重复元素时，覆盖
            number2index.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            Integer complementIndex = number2index.get(target - num);
            if (complementIndex != null && complementIndex != i) {
                return new int[]{i, complementIndex};
            }
        }
        return null;
    }

    /**
     * 只需遍历一次
     */
    @Optimal
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> num2index = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            Integer complementIndex = num2index.get(complement);
            if (complementIndex != null) {
                return new int[]{i, complementIndex};
            }
            num2index.put(nums[i], i);
        }
        return null;
    }



    public void test() {
        System.out.println(JSON.toJSONString(twoSum2(new int[]{2, 2, 7, 11, 15}, 4)));
    }

}
