package backtrack;

import junit.framework.TestCase;
import util.Tag;

import java.util.ArrayList;
import java.util.List;

@Tag("排列组合")
public class P22 extends TestCase {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        helper(n - 1, n, "(", result);
        return result;
    }


    private void helper(int left, int right, String combination, List<String> result) {
        if (right == 0) {
            result.add(combination);
        } else {
            if (left > 0) {
                helper(left - 1, right, combination + "(", result);
            }
            if (right > left) {
                helper(left, right - 1, combination + ")", result);
            }
        }
    }

    public void test() {
        System.out.println(generateParenthesis(3));
    }

}
