/**
 * @author sichu
 * @date 2022/11/30
 **/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int bit1 = a.charAt(i) - '0';
            int bit2 = b.charAt(j) - '0';
            int sum = bit1 + bit2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            --i;
            --j;
        }
        while (i >= 0) {
            int sum = a.charAt(i) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            --i;
        }
        while (j >= 0) {
            int sum = b.charAt(j) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            --j;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
