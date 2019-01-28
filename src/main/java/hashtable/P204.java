package hashtable;


import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import util.UnAcceptable;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class P204 extends TestCase {

	@UnAcceptable
	public int solution_1(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}


	// 更快的一种巧方法
	public int solution_2(int n) {
		boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                if (i <= Math.sqrt(n)) {
                	 for (int j = i;  i*j < n; j++) {
                         notPrime[i*j] = true;
                     }
                }
               
            }
        }
        return count;
	}

	private boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num != i && num % i == 0) {
				return false;
			}
		}
		return true;


	}

	// region test
	public void test() {
		Assertions.assertThat(solution_1(18)).isEqualTo(7);
		Assertions.assertThat(solution_2(18)).isEqualTo(7);
	}
	// endregion
}
