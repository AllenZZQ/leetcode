package hashtable;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P76 extends TestCase {

    /**
     * 很慢
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, List<Integer>> map2 = new HashMap<>();
        int left = 0, right = 0, start = 0, end = 0;
        while (left < s.length() && !map.containsKey(s.charAt(left))) {
            left++;
        }
        right = left;
        boolean flag = false;
        // 思路有点怪，每次ok时，移动左边到最大，然后再移动右边
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map2.putIfAbsent(s.charAt(right), new ArrayList<>());
                map2.get(s.charAt(right)).add(right);

                if (!flag) {
                    if (valid(map, map2)) {
                        flag = true;
                        left = move(map, map2);
                        System.out.println(left + " " + right);
                        start = left;
                        end = right;

                    }
                } else {
                    if (s.charAt(right) == s.charAt(left)) {
                        left = move(map, map2);
                        System.out.println(left + " " + right);
                        if (right - left < end - start) {
                            start = left;
                            end = right;
                        }
                    }
                }

            }
            right ++;
        }
        if (flag) {
            return s.substring(start, end + 1);
        }
        return "";
    }

    /**
     * 正常的滑动窗口
     * 1. 移动右边至true
     * 2. 移动左边至false
     */
    public String minWindow2(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        int start = -1, end = -1;

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            if (dictT.containsKey(c)) {
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and contract the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    if (dictT.containsKey(c)) {
                        if (start == -1 || r - l < end - start) {
                            start = l;
                            end = r;
                        }

                        // The character at the position pointed by the
                        // `Left` pointer is no longer a part of the window.
                        windowCounts.put(c, windowCounts.get(c) - 1);
                        if (windowCounts.get(c) < dictT.get(c)) {
                            formed--;
                        }
                    }
                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }
            }
            // Keep expanding the window once we are done contracting.
            r++;
        }

        return start == -1 ? "" : s.substring(start, end + 1);
    }







    private int move(Map<Character, Integer> map, Map<Character, List<Integer>> map2) {
        int left = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            List<Integer> list = map2.get(entry.getKey());
            left = left == -1 ? list.get(list.size() - entry.getValue()) : Math.min(left, list.get(list.size() - entry.getValue()));
        }
        int limit = left;
        map2.forEach((k, l) -> {
            l.removeIf(x -> x < limit);
        });
        return left;
    }

    private boolean valid(Map<Character, Integer> map, Map<Character, List<Integer>> map2) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()).size() < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void test_01() {
        String a = "aaamcbaa";
        String b = "aacb";
        System.out.println(minWindow2(a, b));
    }

}
