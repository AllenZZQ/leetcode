package backtrack;

import junit.framework.TestCase;
import util.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag("排列组合")
public class P39 extends TestCase {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        int length = candidates.length;
        for (int i = index; i < length; i ++) {
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            helper(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public void test_01() {
        System.out.println(combinationSum(new int[]{2, 3,5}, 8));
    }


}
