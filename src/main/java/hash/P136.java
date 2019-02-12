package hash;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class P136 extends TestCase {
	
	public int solution(int[] nums) {
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


	// region test
	public void test() {
		int[] input = new int[] {1, 2, 2, 4, 3, 4, 1};
		Assertions.assertThat(solution(input)).isEqualTo(3);
	}
	// endregion
}
