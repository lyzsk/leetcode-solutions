import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/09/25 00:13
 */
public class Solution {
    private static StringBuilder getStringBuilder(long numeratorLong, long denominatorLong) {
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        if (remainder != 0) {
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }
        return fractionPart;
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long)numerator;
        long denominatorLong = (long)denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuffer sb = new StringBuffer();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');
        StringBuilder fractionPart = getStringBuilder(numeratorLong, denominatorLong);
        sb.append(fractionPart);
        return sb.toString();
    }
}
