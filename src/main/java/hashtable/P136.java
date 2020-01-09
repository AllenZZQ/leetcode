package hashtable;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class P136 extends TestCase {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
               set.remove(i);
            }
        }
        return set.iterator().next();
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public void test_01() {
        Set<Integer> set = new HashSet<>();
        System.out.println(set.iterator().next());
    }


}
