package stack;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;


public class P20 extends TestCase {



    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                list.add(')');
            } else if (c == '[') {
                list.add(']');
            } else if (c == '{') {
                list.add('}');
            } else {
                if (list.isEmpty() || list.remove(list.size() - 1) != c) {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }


    public void test() {
        System.out.println(isValid("[]"));
    }

}
