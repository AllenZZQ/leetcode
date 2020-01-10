package twopointer;

public class P80 {

    public int removeDuplicates(int[] nums) {
        int p = 2;
        for (int i = 2; i < nums.length; i ++) {
//            if (nums[p -1] != nums[p - 2] || nums[i] != nums[p - 1]) {
            if (nums[i] > nums[p - 2]) { // 更巧妙
                nums[p] = nums[i];
                p ++;
            }
        }
        return p;
    }


}
