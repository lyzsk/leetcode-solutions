import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/11/21
 **/
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 15 == 0) {
                sb.append("FizzBuzz");
            } else if (i % 3 == 0) {
                sb.append("Fizz");
            } else if (i % 5 == 0) {
                sb.append("Buzz");
            } else {
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
