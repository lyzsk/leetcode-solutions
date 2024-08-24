/**
 * @author sichu huang
 * @date 2024/08/23
 **/
public class Solution {
    public String fractionAddition(String expression) {
        //分子
        long n1 = 0;
        //分母
        long d1 = 1;
        int i = 0;
        while (i < expression.length()) {
            long n2 = 0, d2 = 0, sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '+' ? 1 : -1;
                i++;
            }
            //获取分子
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                n2 = n2 * 10 + expression.charAt(i) - '0';
                i++;
            }
            n2 = n2 * sign;
            //移动 除号‘/’
            i++;
            //获取分母
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                d2 = d2 * 10 + expression.charAt(i) - '0';
                i++;
            }
            //相加
            n1 = n1 * d2 + n2 * d1;
            d1 = d1 * d2;
        }
        if (n1 != 0) {
            long gcd = Math.abs(gcd(d1, n1));
            d1 = d1 / gcd;
            n1 = n1 / gcd;
        } else {
            d1 = 1;
        }
        return n1 + "/" + d1;
    }

    private long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }
}
