import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/08/03
 **/
public class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            int n = line.length();
            for (int i = 0; i < n; i++) {
                if (inBlock) {
                    if (i + 1 < n && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        ++i;
                    }
                } else {
                    if (i + 1 < n && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        ++i;
                    } else if (i + 1 < n && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(line.charAt(i));
                    }
                }
            }
            if (!inBlock && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        return res;
    }
}
