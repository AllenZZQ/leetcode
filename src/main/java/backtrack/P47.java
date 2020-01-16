package backtrack;

import util.Tag;

import java.util.*;

/**
 * @see P46
 */
@Tag("排列组合")
public class P47 {

    private Map<Integer, Integer> countMap = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (Integer i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0 ) + 1);
        }
        Arrays.sort(nums);

        helper(nums, new ArrayList<>(), new HashMap<>(), result);
        return result;
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);

        helper2(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void helper2(int[] nums, boolean[] used, List<Integer> list,  List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i ++) {
                if (used[i]) continue;
                used[i] = true;
                list.add(nums[i]);
                helper2(nums, used, list, result);
                used[i] = false;
                list.remove(list.size() - 1);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i ++;
                }
            }
        }
    }

    private void helper(int[] nums, List<Integer> list, Map<Integer, Integer> map, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i ++) {
                int v = nums[i];
                if (map.getOrDefault(v, 0 ) < countMap.get(v)) {
                    map.put(v, map.getOrDefault(v, 0) + 1);
                    list.add(v);
                    helper(nums, list, map, result);
                    list.remove(list.size() - 1);
                    map.put(v, map.get(v) - 1);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i ++;
                }
            }
        }
    }


}
