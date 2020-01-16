package backtrack;

import junit.framework.TestCase;
import util.Tag;

import java.util.ArrayList;
import java.util.List;

@Tag("排列组合")
public class P77 extends TestCase {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k > n) return result;
        helper(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void helper(int n, int k, int start, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            // i <= n + 1 - k + list.size()比较难想到
            for (int i = start; i <= n + 1 - (k - list.size()); i++) {
                list.add(i);
                helper(n, k, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public void test() {
        System.out.println(combine(4, 2));
    }


}
