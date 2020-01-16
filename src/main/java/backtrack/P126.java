package backtrack;

import junit.framework.TestCase;
import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class P126 extends TestCase {

    /**
     * 效率低
     * 每个word相邻的word是确定的，但这个确定性没有利用起来，每次都是遍历全部，找到相邻word
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (beginWord.length() != endWord.length()) return result;
        wordList = wordList.stream().filter(x -> x.length() == beginWord.length()).collect(Collectors.toList());
        if (!wordList.contains(endWord)) return result;

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        helper(endWord, wordList, list, result);
        return result;
    }

    private void helper(String endWord, List<String> wordList, List<String> list, List<List<String>> result) {
        if (!result.isEmpty() && list.size() > result.get(0).size()) {
            return;
        }
        if (list.get(list.size() - 1).equals(endWord)) {
            if (result.isEmpty()) {
                result.add(new ArrayList<>(list));
            } else {
                int size = result.get(0).size();
                if (list.size() == size) {
                    result.add(new ArrayList<>(list));
                }
                if (list.size() < size) {
                    result.clear();
                    result.add(new ArrayList<>(list));
                }
            }
        } else {
            String lastWord = list.get(list.size() - 1);
            for (int i = 0; i < wordList.size(); i++) {
                String str = wordList.get(i);
                if (!list.contains(str)) {
                    if (valid(lastWord, str)) {
                        list.add(str);
                        helper(endWord, wordList, list, result);
                        list.remove(list.size() - 1);
                        if (str.equals(endWord)) {
                            break;
                        }
                    }
                }
            }

        }
    }

    private boolean valid(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return diff == 1;
    }


    public List<List<String>> findLadders2(String start, String end, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
        Map<String, Integer> distanceMap = new HashMap<>();
        bfs(start, end, wordList, nodeNeighbors, distanceMap);

        List<String> list = new ArrayList<>();
        list.add(start);
        dfs(end, nodeNeighbors, distanceMap, list, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, List<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distanceMap.put(start, 0);

        while (!queue.isEmpty()) {
            boolean foundEnd = false;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int distance = distanceMap.get(cur);

                List<String> neighbors = getNeighbors(cur, dict);
                nodeNeighbors.put(cur, neighbors);
                for (String neighbor : neighbors) {
                    if (!distanceMap.containsKey(neighbor)) {
                        distanceMap.put(neighbor, distance + 1);
                        queue.offer(neighbor);
                    }

                    if (neighbor.equals(end)) {
                        foundEnd = true;
                    }

                }
            }
            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private List<String> getNeighbors(String node, List<String> dict) {
        List<String> list = new ArrayList<>();
        for (String str : dict) {
            if (valid(node, str)) {
                list.add(str);
            }
        }
        return list;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String end, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distanceMap, List<String> list, List<List<String>> res) {
        if (list.get(list.size() - 1).equals(end)) {
            res.add(new ArrayList<>(list));
        } else {
            List<String> neighbours = nodeNeighbors.get(list.get(list.size() - 1));
            if (neighbours == null) return;
            int distance = distanceMap.get(list.get(list.size() - 1));

            for (String str : neighbours) {
                if (distanceMap.get(str) == distance + 1) {
                    list.add(str);
                    dfs(end, nodeNeighbors, distanceMap, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    // TODO zhaoziqiang 2020-01-15 还没看
    public List<List<String>> findLadders3(String start, String end, List<String> list) {
        // hash set for both ends
        Set<String> dict = new HashSet<>(list);
        if (!dict.contains(end)) return new ArrayList<>();
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        // initial words in both ends
        set1.add(start);
        set2.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // build the map
        helper(dict, set1, set2, map, false);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
    }

    boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
            return false;
        }

        if (set1.size() > set2.size()) {
            return helper(dict, set2, set1, map, !flip);
        }

        // remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();

                // change one character for every position
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;

                    String word = new String(chars);

                    // make sure we construct the tree in the correct direction
                    String key = flip ? word : str;
                    String val = flip ? str : word;

                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

                    if (set2.contains(word)) {
                        done = true;

                        list.add(val);
                        map.put(key, list);
                    }

                    if (!done && dict.contains(word)) {
                        set.add(word);

                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }

        // early terminate if done is true
        return done || helper(dict, set2, set, map, !flip);
    }

    void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList<String>(sol));
            return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
            return;
        }

        for (String word : map.get(start)) {
            sol.add(word);
            generateList(word, end, map, sol, res);
            sol.remove(sol.size() - 1);
        }
    }


    public void test() {
        System.out.println(findLadders2("a", "c", Lists.newArrayList("a", "b", "c")));
    }


}
