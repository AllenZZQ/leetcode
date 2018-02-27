package hashtable;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class P136 {
	
	public int singleNumber(int[] nums) {
		/*
		 *  异或操作
		 *  a xor a xor b = 0 xor b = b
		 */
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}
		return a;
	}
	
	public static void main(String[] args) {
		
	}
}
