package math;

import junit.framework.TestCase;

public class P149 extends TestCase {

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int size = points.length;
        int ans = 1;
        for (int i = 0; i < size; i ++) {
            if (size - i <= ans) break;
            int repeat = 1;
            int temp = repeat;
            for (int j = i + 1; j < size; j ++) {
                if (size - j + temp <= ans) break;
                temp ++;
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    repeat ++;
                    ans = Math.max(ans, temp);
                    continue;
                }

                for (int p = j + 1; p < size; p ++) {
                    if (size - p + temp <= ans) break;

                    int x3 = points[p][0];
                    int y3 = points[p][1];
                    if ((long) (y2 - y1) * (x3 - x1) == (long) (y3 - y1) * (x2 - x1)) {
                        temp ++;
                    }
                }

                ans = Math.max(ans, temp);
                temp = repeat;
            }
        }
        return ans;
    }

    public void test_01() {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {1, 1}};
        System.out.println(maxPoints(points));
        int ans = 0;
        for (int i = 0; i < points.length; i ++) {
            int x = points[i][0];
            int y = points[i][1];
            if (-x + 77 == y) {
//                System.out.println(i);
                ans ++;
            }
        }
//        System.out.println("ans " + ans);
    }

}
