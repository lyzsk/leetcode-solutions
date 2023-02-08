import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu
 * @date 2023/02/08
 **/
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            int pre = res.get(res.size() - 1).length();
            if (!(pre < folder[i].length() && res.get(res.size() - 1).equals(folder[i].substring(0, pre))
                && folder[i].charAt(pre) == '/')) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}
