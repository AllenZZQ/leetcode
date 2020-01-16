package backtrack;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class P60 extends TestCase {

    public String getPermutation(int n, int k) {
        int total = 1;
        for (int i = n; i > 1; i--) {
            total *= i;
        }

        if (k < total / 2) {
            return helper(n, new int[]{0}, k, new ArrayList<>(), true);
        } else {
            return helper(n, new int[]{0}, total - k + 1, new ArrayList<>(), false);
        }
    }

    /**
     * 数学规律来找
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

    private String helper(int n, int[] s, int k, List<Integer> list, boolean b) {
        if (list.size() == n) {
            s[0]++;
            if (s[0] == k) {
                StringBuilder builder = new StringBuilder();
                for (int i : list) {
                    builder.append(i);
                }
                return builder.toString();
            }
            return null;
        } else {
            if (b) {
                for (int i = 1; i <= n; i++) {
                    if (!list.contains(i)) {
                        list.add(i);
                        String str = helper(n, s, k, list, b);
                        if (str != null) return str;
                        list.remove(list.size() - 1);
                    }
                }
            } else {
                for (int i = n; i >= 1; i--) {
                    if (!list.contains(i)) {
                        list.add(i);
                        String str = helper(n, s, k, list, b);
                        if (str != null) return str;
                        list.remove(list.size() - 1);
                    }
                }
            }
            return null;
        }
    }

    public void test() {
        System.out.println(1.0 * 2);
    }


}
