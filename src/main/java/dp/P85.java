package dp;

public class P85 {

    /**
     * 在84题的基础上，把每一行都转换成84题来求解
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i ++) {
            char[] row = matrix[i];
            for (int j = 0; j < row.length; j ++) {
                if (row[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    private int largestRectangleArea(int[] heights) {
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
}
