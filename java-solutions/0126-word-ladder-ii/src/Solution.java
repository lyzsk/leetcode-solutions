import java.util.*;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        dict.remove(beginWord);
        Map<String, Integer> steps = new HashMap<>(16);
        steps.put(beginWord, 0);
        Map<String, List<String>> from = new HashMap<>(16);
        int step = 1;
        boolean found = false;
        int len = beginWord.length();
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.removeFirst();
                char[] arr = curWord.toCharArray();
                for (int j = 0; j < len; j++) {
                    char origin = arr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String nextWord = String.valueOf(arr);
                        if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                            from.get(nextWord).add(curWord);
                        }
                        if (!dict.contains(nextWord)) {
                            continue;
                        }
                        dict.remove(nextWord);
                        queue.addLast(nextWord);
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(curWord);
                        steps.put(nextWord, step);
                        if (nextWord.equals(endWord)) {
                            found = true;
                        }
                    }
                    arr[j] = origin;
                }
            }
            ++step;
            if (found) {
                break;
            }
        }
        if (found) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backtrack(from, path, beginWord, endWord, res);
        }
        return res;
    }

    private void backtrack(Map<String, List<String>> from, Deque<String> path, String beginWord, String curWord,
        List<List<String>> res) {
        if (curWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String precursor : from.get(curWord)) {
            path.addFirst(precursor);
            backtrack(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }
}
