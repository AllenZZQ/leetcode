package backtrack;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class P17 extends TestCase {

    // backtrack
    // 如果错误或者不是最终解，调整后重试直到正确或达到最终解。一种递归算法
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, char[]> digit2chars = new HashMap<>();
        digit2chars.put('2', new char[]{'a', 'b', 'c'});
        digit2chars.put('3', new char[]{'d', 'e', 'f'});
        digit2chars.put('4', new char[]{'g', 'h', 'i'});
        digit2chars.put('5', new char[]{'j', 'k', 'l'});
        digit2chars.put('6', new char[]{'m', 'n', 'o'});
        digit2chars.put('7', new char[]{'p', 'q', 'r', 's'});
        digit2chars.put('8', new char[]{'t', 'u', 'v'});
        digit2chars.put('9', new char[]{'w', 'x', 'y', 'z'});


        List<String> result = new ArrayList<>();
        backTrack(result, digit2chars, digits, "");
        return result;
    }

    private void backTrack(List<String> result, Map<Character, char[]> digit2chars, String digits, String str) {
        if (digits.length() == 0) {
            result.add(str);
        } else {
            char[] characters = digit2chars.get(digits.charAt(0));
            for (char c : characters) {
               backTrack(result, digit2chars, digits.substring(1), str + String.valueOf(c));
            }
        }
    }


    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        MapHolder mapHolder = new MapHolder();
        mapHolder.map = map;
        System.out.println(JSON.toJSONString(mapHolder));
    }

}

class MapHolder {
    public Map<Integer, Integer> map;
}
