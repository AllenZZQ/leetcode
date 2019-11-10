package dp;

import junit.framework.TestCase;
import util.Difficult;

@Difficult
public class P84 extends TestCase {


    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length]; // 每个index处左边第一个比它高度小的index
        int[] lessFromRight = new int[heights.length]; // 每个index处右边第一个比它高度小的index
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i ++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = heights.length - 2; i >= 0; i --) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i ++) {
            ans = Math.max(ans, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return ans;
    }

    /**
     * brute force
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i ++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j ++) {
                minHeight = Math.min(minHeight, heights[j]);
                ans = Math.max(ans, (j - i + 1) * minHeight);
            }
        }
        return ans;
    }


    public void test() {
        int[] ints = new int[]{2,1,1,1,1,1};
        largestRectangleArea(ints);
    }






}
