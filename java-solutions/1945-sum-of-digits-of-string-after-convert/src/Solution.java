/**
 * @author sichu
 * @date 2022/12/14
 **/
public class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }
        String res = sb.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char ch : res.toCharArray()) {
                sum += ch - '0';
            }
            res = Integer.toString(sum);
        }
        return Integer.parseInt(res);
    }
}
