package hashtable;

import junit.framework.TestCase;

import java.util.*;


public class P13 extends TestCase {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        Set<String> set = new HashSet<>();
        set.add("I");
        set.add("X");
        set.add("C");

        int ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            String c = String.valueOf(s.charAt(i));
            if (i < s.length() - 1 && set.contains(c)) {
                String d = String.valueOf(s.charAt(i + 1));
                Integer value = map.get(c + d);
                if (value != null) {
                    i ++;
                    ans += value;
                } else {
                    ans += map.get(c);
                }
            } else {
                ans += map.get(c);
            }
        }

        return ans;
    }



    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
