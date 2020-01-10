package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 0, 3, 0);
    }

    public static ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        int len = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
            int i = index, j = len - 1;
            while(i < j) {
                //find a pair
                if(target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target-nums[i]);
                    res.add(temp);
                    //skip duplication
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    while(i<j && nums[i]==nums[i+1]) i++;
                    i++;
                    //move right bound
                } else {
                    while(i<j && nums[j-1]==nums[j]) j--;
                    j--;
                }
            }
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                //add previous results
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }


}
