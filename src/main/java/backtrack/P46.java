package backtrack;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class P46 extends TestCase {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (!list.contains(num)) {
                    list.add(num);
                    backtrack(result, list, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

}
