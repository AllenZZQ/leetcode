package hashtable;

import java.util.HashSet;
import java.util.Set;

public class P219 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// 蠢办法
		/*
		 * for (int i = 0; i < nums.length - 1; i ++) { for (int j = i + 1; j < i + k &&
		 * j < nums.length; j ++) { if (nums[i] == nums[j]) { return true; } } } return
		 * false;
		 */
		// 法1
		/*
		 * Map<Integer, Integer> map = new HashMap<>(); for (int i = 0; i < nums.length;
		 * i ++) { int temp = nums[i]; if (map.containsKey(temp)) { if (i -
		 * map.get(temp) <= k) { return true; } } map.put(temp, i); } return false;
		 */
		// 法2
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
