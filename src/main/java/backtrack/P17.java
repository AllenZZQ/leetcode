package backtrack;

import junit.framework.TestCase;
import util.Tag;

import java.util.*;

@Tag("排列组合")
public class P17 extends TestCase {

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        helper2(digits, 0, "", result);
        return result;
    }

    private void helper2(String digits, int index, String combination, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
        } else {
            String str = map.get(digits.charAt(index));
            for (char c : str.toCharArray()) {
                helper2(digits, index + 1, combination + c, result);
            }
        }
    }


    String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> vals = new LinkedList<>();
        if(digits.length() == 0) return vals;

        vals.offer("");
        while(vals.peek().length() != digits.length()){
            String cur = vals.poll();
            String letters = keys[digits.charAt(cur.length()) - '0'];
            for(char c : letters.toCharArray())
                vals.offer(cur + c);
        }
        return vals;
    }


    public void test_01() {
        int c = '2' - '0';
        System.out.println(c);
    }

}
