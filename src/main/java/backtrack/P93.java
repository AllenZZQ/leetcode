package backtrack;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class P93 extends TestCase {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int index, List<Integer> list, List<String> result) {
        if (list.size() == 4) {
            StringBuilder builder = new StringBuilder();
            for (Integer i : list) {
                builder.append(i).append(".");
            }
            builder.deleteCharAt(builder.length() - 1);
            result.add(builder.toString());
        } else if (index < s.length()) {
            if (list.size() == 3) {
                if (s.length() - index > 3) return;
                String str = s.substring(index);
                if (str.charAt(0) == '0' && str.length() > 1) {
                    return;
                }
                Integer integer = Integer.parseInt(str);
                if (integer <= 255) {
                    list.add(integer);
                    helper(s, s.length(), list, result);
                    list.remove(list.size() - 1);
                }
            } else {
                for (int i = index + 1; i <= s.length(); i ++) {
                    String str = s.substring(index, i);
                    if (str.charAt(0) == '0') {
                        list.add(0);
                        helper(s, i, list, result);
                        list.remove(list.size() - 1);
                        break;
                    } else {
                        Integer integer = Integer.parseInt(str);
                        if (integer <= 255) {
                            list.add(integer);
                            helper(s, i, list, result);
                            list.remove(list.size() - 1);
                        } else {
                            break;
                        }
                    }

                }
            }
        }
    }


}
