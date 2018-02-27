package hashtable;


/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class P204 {

	public int countPrimes(int n) {
		/*int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;*/
		// 更快的一种巧方法
		boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
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

	public static void main(String[] args) {
		System.out.println(new P204().countPrimes(1500000));
	}
}
