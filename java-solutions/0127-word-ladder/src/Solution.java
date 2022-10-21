import java.util.*;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    private final Map<String, Integer> wordId = new HashMap<>(16);
    private final List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;
        Deque<Integer> queueBegin = new ArrayDeque<>();
        queueBegin.addLast(beginId);
        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;
        Deque<Integer> queueEnd = new ArrayDeque<>();
        queueEnd.addLast(endId);
        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            int queueBeginSize = queueBegin.size();
            for (int i = 0; i < queueBeginSize; i++) {
                int nodeBegin = queueBegin.removeFirst();
                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }
                for (int it : edge.get(nodeBegin)) {
                    if (disBegin[it] == Integer.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queueBegin.addLast(it);
                    }
                }
            }
            int queueEndSize = queueEnd.size();
            for (int i = 0; i < queueEndSize; i++) {
                int nodeEnd = queueEnd.removeFirst();
                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }
                for (int it : edge.get(nodeEnd)) {
                    if (disEnd[it] == Integer.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queueEnd.addLast(it);
                    }
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            arr[i] = '*';
            String newWord = new String(arr);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            arr[i] = temp;
        }
    }

    private void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
