package backtrack;

import util.Tag;

import java.util.ArrayList;
import java.util.List;

@Tag("排列组合")
public class P46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        helper(nums,  new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i : nums) {
                if (!list.contains(i)) {
                    list.add(i);
                    helper(nums, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


}
