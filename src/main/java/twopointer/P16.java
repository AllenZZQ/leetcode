package twopointer;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16 extends TestCase {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
//        System.out.println(JSON.toJSONString(kSum(nums, target, 3, 0, Integer.MAX_VALUE)));
        return kSum(nums, target, 3, 0, Integer.MAX_VALUE).stream().mapToInt(x -> x).sum();
    }


    private List<Integer> kSum(int[] nums, int target, int k, int index, int minGap) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                int numI = nums[i];
                int numJ = nums[j];
                //find a pair
                if (target - numI > numJ) {

                    while (i < j && nums[i] == nums[i + 1]) i++;
                    i++;
                    //move right bound
                } else {
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    j--;
                }
                if (Math.abs(target - numI - numJ) < minGap) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(numI);
                    temp.add(numJ);
                    res = temp;
                    minGap = Math.abs(target - numI - numJ);
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                List<Integer> temp = kSum(nums, target - nums[i], k - 1, i + 1, minGap);
                if (temp.size() > 0) {
                    //add previous results
                    temp.add(0, nums[i]);
                    minGap = Math.abs(target - temp.stream().mapToInt(x -> x).sum());
                    res = temp;
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }


    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, 4}, 1));
    }

}
