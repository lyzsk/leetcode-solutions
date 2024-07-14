import java.util.*;

/**
 * @author sichu huang
 * @date 2024/07/14
 **/
public class Solution {
    private int i;
    private int n;
    private String formula;

    public String countOfAtoms(String formula) {
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                ++i;
                stack.push(new HashMap<>());
            } else if (ch == ')') {
                ++i;
                int num = parseNum();
                Map<String, Integer> popMap = stack.pop();
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int value = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + value * num);
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num);
            }
        }
        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    private int parseNum() {
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + (formula.charAt(i) - '0');
            ++i;
        }
        return num;
    }

    public String parseAtom() {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(i));
        ++i;
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i));
            ++i;
        }
        return sb.toString();
    }
}
