package dynamicProgramming;

import junit.framework.TestCase;
import util.Difficult;
import util.UnAcceptable;

import java.util.Stack;


public class P32 extends TestCase {

    // brute force
    @UnAcceptable
    public int longestValidParentheses_01(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int length = 1, balance = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    length++;
                    balance = s.charAt(j) == '(' ? balance + 1 : balance - 1;
                    if (balance == 0) {
                        max = Math.max(max, length);
                    }
                    if (balance < 0) {
                        break;
                    }
                }
            }
        }
        return max;
    }


    @Difficult
    public int longestValidParentheses_02(String s) {
        int maxans = 0;
        // store '('的index
        Stack<Integer> stack = new Stack<>();
        // 初始化'('的index
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // ）说明可以配平，pop一个（
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    // dynamic Programming
    @Difficult
    public int longestValidParentheses_03(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    public void test() {
        System.out.println(longestValidParentheses_02(")))())()))"));
    }

}
