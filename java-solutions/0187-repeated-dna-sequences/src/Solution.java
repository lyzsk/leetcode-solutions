import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/11/14
 **/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10 || s.length() > 100000) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i <= chs.length - 10; i++) {
            String str = String.valueOf(chs, i, 10);
            if (!set.add(str)) {
                res.add(str);
            }
        }
        return new ArrayList<>(res);
    }
}
