package backtrack;

import junit.framework.TestCase;
import util.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see P78
 */
@Tag("排列组合")
public class P90 extends TestCase {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> list , List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i ++) {
            list.add(nums[i]);
            helper(nums, i + 1, list, result);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i ++;
            }
        }
    }

    public void test() {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }


}
