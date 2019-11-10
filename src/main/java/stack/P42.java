package stack;

import util.Difficult;

import java.util.Stack;

@Difficult
public class P42 {

    /**
     * stack
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>(); // 存储index
        for (int i = 0; i < height.length; i ++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * h;
            }
            stack.push(i);
        }
        return ans;
    }



}
