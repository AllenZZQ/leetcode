package array;

import junit.framework.TestCase;
import util.Easy;

@Easy
public class P48 extends TestCase {

    /**
     * 顺时针：先上下交换，然后对角线交换
     * 逆时针：先左右交换，然后对角线交换
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i ++) {
            for (int m = 0, n = matrix.length - 1; m < n; m ++, n --) {
                int temp = matrix[m][i];
                matrix[m][i] = matrix[n][i];
                matrix[n][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length - 1; i ++) {
            for (int j = i + 1; j < matrix[i].length; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


}
