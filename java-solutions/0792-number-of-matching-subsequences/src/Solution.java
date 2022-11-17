import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/11/17
 **/
public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String word : words) {
            if (word.length() > s.length()) {
                --res;
                continue;
            }
            int ptr = -1;
            for (int i = 0; i < word.length(); i++) {
                List<Integer> list = pos[word.charAt(i) - 'a'];
                if (list.isEmpty() || list.get(list.size() - 1) <= ptr) {
                    --res;
                    break;
                }
                ptr = binarySearch(list, ptr);
            }
        }
        return res;
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (target < list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
