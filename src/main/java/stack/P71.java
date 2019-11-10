package stack;

import junit.framework.TestCase;

import java.util.Deque;
import java.util.LinkedList;

public class P71 extends TestCase {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> deque = new LinkedList<>(); // 双向队列
        for (String s : strs) {
            if (s.equals("..") && !deque.isEmpty()) {
                deque.pop();
            }
            if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                deque.push(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append("/").append(deque.removeLast());
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public void test() {
        String s = "/..//";
        System.out.println(s.split("/").length);
        System.out.println(s.split("/")[0]);
        System.out.println(s.split("/")[1]);
    }
}
