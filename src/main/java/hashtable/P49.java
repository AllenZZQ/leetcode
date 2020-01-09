package hashtable;

import java.util.*;

public class P49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        result.addAll(map.values());
        return result;
    }


}
