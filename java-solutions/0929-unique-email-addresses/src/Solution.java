import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/11/20
 **/
public class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] splits = email.split("@");
            StringBuilder sb = new StringBuilder();
            for (char ch : splits[0].toCharArray()) {
                if (ch == '+') {
                    break;
                }
                if (ch == '.') {
                    continue;
                }
                sb.append(ch);
            }
            sb.append("@").append(splits[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
