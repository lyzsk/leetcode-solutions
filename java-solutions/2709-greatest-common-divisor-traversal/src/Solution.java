import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2024/02/25
 **/
public class Solution {
    private int[] p = new int[100010];
    private Set<Integer> st = new HashSet<>();

    public boolean canTraverseAllPairs(int[] nums) {
        for (int i : nums) {
            if (i == 1) {
                return nums.length == 1;
            }
            int tmp = i;
            int lst = 1;
            for (int j = 2; j <= Math.sqrt(tmp); j++) {
                if (tmp % j == 0) {
                    if (p[j] == 0) {
                        p[j] = j;
                        st.add(j);
                    }
                    if (lst != 1) {
                        merge(lst, j);
                    }
                    lst = j;
                    while (tmp % j == 0) {
                        tmp /= j;
                    }
                }
            }
            if (tmp > 1) {
                if (p[tmp] == 0) {
                    p[tmp] = tmp;
                    st.add(tmp);
                }
                if (lst != 1) {
                    merge(lst, tmp);
                }
            }

        }
        return st.size() == 1;
    }

    private int find(int x) {
        return p[x] == x ? p[x] : (p[x] = find(p[x]));
    }

    private void merge(int a, int b) {
        if (a < b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        st.remove(find(b));
        p[find(b)] = find(a);
        st.add(find(a));
    }
}
