import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/08/27
 **/
public class Solution {
    private final Set<String> set = new HashSet<>();

    private static String countDigits(int n) {
        char[] count = new char[10];
        while (n > 0) {
            ++count[n % 10];
            n /= 10;
        }
        return new String(count);
    }

    public boolean reorderedPowerOf2(int n) {
        for (int i = 1; i < 1e9; i <<= 1) {
            set.add(countDigits(i));
        }
        return set.contains(countDigits(n));
    }
}
