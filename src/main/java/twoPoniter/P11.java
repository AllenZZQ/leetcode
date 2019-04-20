package twoPoniter;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import util.NotSolved;
import util.UnAcceptable;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

@NotSolved
public class P11 extends TestCase {

    @UnAcceptable
    public int maxArea_1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i ++) {
            int x = height[i];
            for (int j = i + 1; j < height.length; j ++) {
                int y = height[j];
                max = Math.max((j - i) * Math.min(x, y), max);
            }
        }
        return max;
    }

    public int maxArea_2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int x = height[i];
            int y = height[j];
            max = Math.max(Math.min(x, y) * (j - i), max);
            if (x <= y) {
                i ++;
            } else {
                j --;
            }
        }
        return max;
    }


    public void test() {
        Assertions.assertThat(maxArea_2(new int[]{1,8,6,2,5,4,8,3,7})).isEqualTo(49);
    }


}
