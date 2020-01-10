package twopointer;

public class P26 {

    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0, length = 0;
        while (right < nums.length) {
            nums[left] = nums[right];
            length ++;
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right ++;
            }
            left ++;
            right ++;
        }
        return length;
    }

    public int removeDuplicates2(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != nums[p]) {
                p ++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }

}
