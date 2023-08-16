import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2023/08/16
 **/
public class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        for (int i = k, j = 0; !visited[j]; i += k) {
            visited[j] = true;
            j = (j + i) % n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(i + 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
