package twopointer;

public class P27 {


    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p ++;
            }
        }
        return p;
    }


}
