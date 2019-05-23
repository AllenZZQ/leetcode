package math;

import junit.framework.TestCase;


public class P7 extends TestCase {

    /**
     * 注意如何翻转就行
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int remiander = x % 10;
            x /= 10;
            if (ans > 214748364 || (ans == 214748364 && remiander > 7)) {
                return 0;
            }
            if (ans < -214748364 || (ans == -214748364 && remiander < -8)) {
                return 0;
            }
            ans = ans * 10 + remiander;
        }
        return ans;
    }



    public void test() {
        System.out.println(Double.MAX_VALUE);
    }

}
