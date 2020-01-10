package twopointer;

public class P88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[m + n];
        int i = 0;
        int a = 0, b = 0;
        while (a < m && b < n) {
            if (nums1[a] <= nums2[b]) {
                array[i ++] = nums1[a ++];
            } else {
                array[i ++] = nums2[b ++];
            }
        }
        while (a < m) {
            array[i ++] = nums1[a ++];
        }
        while (b < n) {
            array[i ++] = nums2[b ++];
        }
        System.arraycopy(array, 0, nums1, 0, m + n);
    }
}
