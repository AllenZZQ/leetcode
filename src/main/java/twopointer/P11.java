package twopointer;

import junit.framework.TestCase;


public class P11 extends TestCase {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, ans = 0;

        while (i < j) {
            int h1 = height[i];
            int h2 = height[j];
            ans = Math.max(ans, Math.min(h1, h2) * (j - i));
            if (h1 < h2) {
                i ++;
            } else {
                j --;
            }
        }
        return ans;
    }



    public void test() {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}
