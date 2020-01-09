package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P30 {



    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int length = words[0].length();
        int allLenght = length * words.length;
        for (int i = 0; i <= s.length() - allLenght; i ++) {
            if (check(s.substring(i, i + allLenght), length, map)) {
                result.add(i);
            }
        }
        return result;
    }



    private boolean check(String substring, int length, Map<String, Integer> map) {
        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < substring.length(); i += length) {
            String str = substring.substring(i, i + length);
            if (!map.containsKey(str)) return false;
            temp.put(str, temp.getOrDefault(str, 0) + 1);
            if (temp.get(str) > map.get(str)) {
                return false;
            }
        }
        return true;
    }


}
