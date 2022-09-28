import java.util.*;

/**
 * @author sichu
 * @date 2022/08/21
 **/
public class Solution {
    /**
     * 从stamp->?逆推成?->stamp
     * 维护两个hashset: made && todo
     * made表示可以匹配的位置
     * todo表示不可匹配的位置
     * 只有当todo为null, 这个窗口才能被戳印,即把字符从lowercase变成?
     * 用queue存储所有为变成?的字符的位置
     *
     * @param stamp  given string
     * @param target target string
     * @return int[] contains each step's start index
     */
    public int[] movesToStamp(String stamp, String target) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] done = new boolean[target.length()];
        Deque<Integer> ans = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < target.length() - stamp.length(); i++) {
            Set<Integer> made = new HashSet<>();
            Set<Integer> todo = new HashSet<>();
            for (int j = 0; j < stamp.length(); j++) {
                if (target.charAt(i + j) == stamp.charAt(j)) {
                    made.add(i + j);
                } else {
                    todo.add(i + j);
                }
            }
            list.add(new Node(made, todo));
            if (todo.isEmpty()) {
                ans.addFirst(i);
                for (int j = i; j < i + stamp.length(); j++) {
                    if (!done[j]) {
                        queue.add(j);
                        done[j] = true;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = Math.max(0, i - stamp.length() + 1); j < Math.min(target.length() - stamp.length(), i); j++) {
                if (list.get(j).todo.contains(i)) {
                    list.get(j).todo.remove(i);
                    if (list.get(j).todo.isEmpty()) {
                        ans.addFirst(j);
                        for (int m : list.get(j).made) {
                            queue.add(m);
                            done[m] = true;
                        }
                    }
                }
            }
        }
        for (boolean d : done) {
            if (!d) {
                return new int[0];
            }
        }
        int[] res = new int[ans.size()];
        int t = 0;
        while (!ans.isEmpty()) {
            res[t] = ans.removeFirst();
            ++t;
        }
        return res;
    }
}

class Node {
    public Set<Integer> made;
    public Set<Integer> todo;

    public Node(Set<Integer> made, Set<Integer> todo) {
        this.made = made;
        this.todo = todo;
    }
}