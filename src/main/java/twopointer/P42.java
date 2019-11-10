package twopointer;

import util.Difficult;

@Difficult
public class P42 {
    /**
     * two pointer
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftmax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftmax) {
                    leftmax = height[left];
                } else {
                    ans += leftmax - height[left];
                }
                left ++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right --;
            }
        }
        return ans;
    }

}
