package backtrack;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class P22 extends TestCase {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(result, n, "", 0, 0);
        return result;
    }

    private void backtrack(List<String> result, int n, String str, int open, int close) {
        if (str.length() == n * 2) {
            result.add(str);
        } else {
            if (open < n) {
                backtrack(result, n, str + '(', open + 1, close);
            }
            if (close < open) {
                backtrack(result, n, str + ')', open, close + 1);
            }
        }
    }


    public void test() {
        System.out.println(generateParenthesis(3));
    }

}
