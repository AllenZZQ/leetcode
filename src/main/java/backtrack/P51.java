package backtrack;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class P51 extends TestCase {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;

        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                chars[i][j] = '.';
            }
        }
        helper(n, 0, 0,  chars, result);
        return result;
    }

    private void helper(int n, int i, int row, char[][] chars, List<List<String>> result) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int p = 0; p < chars.length; p ++) {
                list.add(String.valueOf(chars[p]));
            }
            result.add(list);
        } else {
            // 注意重复问题，一开始没有row这个变量，每行遍历会重复计入
            for (int q = 0; q < n; q ++) {
                if (chars[row][q] == '.') {
                    if (valid(chars, row, q)) {
                        chars[row][q] = 'Q';
                        helper(n, i + 1, row + 1, chars, result);
                        chars[row][q] = '.';
                    }
                }
            }
        }
    }

    private boolean valid(char[][] chars, int p, int q) {
        for (int i = 0; i < chars.length; i ++) {
            char[] tempChars = chars[i];
            if (i == p) {
                for (int j = 0; j < tempChars.length; j ++) {
                    if (tempChars[j] == 'Q') return false;
                }
            }
            if (tempChars[q] == 'Q') return false;
            if (q + p - i >= 0 && q + p - i < tempChars.length && tempChars[q + p - i] == 'Q') return false;
            if (q + i - p >= 0 && q + i - p < tempChars.length && tempChars[q + i - p] == 'Q') return false;
        }
        return true;
    }

    public void test() {
        System.out.println(solveNQueens(4));
    }


}
