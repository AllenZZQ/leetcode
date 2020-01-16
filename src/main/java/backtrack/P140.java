package backtrack;

import junit.framework.TestCase;
import org.assertj.core.util.Lists;

import java.util.*;

public class P140 extends TestCase {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 ||
                wordDict == null || wordDict.size() == 0) return new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        List<List<String>> result = new ArrayList<>();
        helper(s, dict, new ArrayList<>(), result);

        List<String> res = new ArrayList<>();
        for (List<String> l : result) {
            res.add(String.join(" ", l));
        }
        return res;
    }

    private void helper(String s, Set<String> dict, List<String> list, List<List<String>> result) {
        if (s.isEmpty()) {
            result.add(new ArrayList<>(list));
        } else {
            for (String str : dict) {
                if (s.startsWith(str)) {
                    list.add(str);
                    helper(s.substring(str.length()), dict, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return DFS(s, new HashSet<>(wordDict), new HashMap<>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, Map<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }


    public void test() {
        System.out.println(wordBreak2("catsanddog", Lists.newArrayList("cat", "cats", "and", "sand", "dog")));

    }

}
