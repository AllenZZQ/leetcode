package twopointer;

import java.util.*;

public class P18 {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return P15.kSum(nums, target, 4, 0);
    }



}
