package tree;

import junit.framework.TestCase;

/**
 * @see P95
 */
public class P96 extends TestCase {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return doNumTrees(1, n);
    }

    public int numTrees2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int len = 1; len <= n; len ++) {
            for (int j = 0; j < len; j ++) {
                result[len] += result[j] * result[len - j - 1];
            }
        }
        return result[n];
    }

    private int doNumTrees(int start, int end) {
        if (start > end) {
            return 1;
        }
        int result = 0;
        for (int i = start; i <= end; i ++) {
            int l = doNumTrees(start, i - 1);
            int r = doNumTrees(i + 1, end);
            result += l * r;
        }
        return result;
    }

    public void test() {
        long s1 = System.currentTimeMillis();
        System.out.println(numTrees2(18));
        long s2 = System.currentTimeMillis();
        System.out.println((s2 - s1) / 1000.0);
//        System.out.println(numTrees2(100));
    }

}
