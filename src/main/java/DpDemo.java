import junit.framework.TestCase;

/**
 * 斐波那契数列
 */
public class DpDemo extends TestCase {


    public int fbnq(int n) {
        if (n <= 2) return n;
        return fbnq(n - 1) + fbnq(n - 2);
    }

    public int fbnq2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }




    public void test() {
        System.out.println(fbnq(10));
        System.out.println(fbnq2(10));
    }


}
