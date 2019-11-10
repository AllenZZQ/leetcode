package dp;

public class P42 {

    /**
     * 每个柱子能盛水的量为其min(左max，右max)-自身高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i ++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i --) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int ans = 0;
        for (int i = 1; i < height.length -1; i ++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
