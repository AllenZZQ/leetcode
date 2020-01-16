package backtrack;

import util.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag("排列组合")
public class P40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            helper(candidates, i + 1, target - candidates[i], list, result);
            list.remove(list.size() - 1);

            while (i < length - 1 && candidates[i] == candidates[i + 1]) {
                i ++;
            }
        }
    }


}
