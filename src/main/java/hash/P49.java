package hash;

import junit.framework.TestCase;

import java.util.*;


public class P49 extends TestCase {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
           char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());

    }


}
