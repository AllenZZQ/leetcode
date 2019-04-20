package brute;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 *
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 *
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 */

public class P13 extends TestCase {

    public int romanToInt(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        for (int i = 0; i < s.length();) {
            String a = s.substring(i, i + 1);
            String b = i == s.length() - 1 ? a : s.substring(i, i + 2);
            if (map.containsKey(b)) {
                i += 2;
                result += map.get(b);
            } else {
                i += 1;
                result += map.get(a);
            }
        }
        return result;
    }


    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
