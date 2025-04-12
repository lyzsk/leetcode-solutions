/**
 * @author sichu huang
 * @since 2025/04/10 19:03
 */
public class Solution {
    public long numberOfPowerfulInt(long rangeStart, long rangeEnd, int chakraLimit,
        String clanSymbolSuffix) {
        return countPowerfulShinobi(rangeEnd, chakraLimit, clanSymbolSuffix) - countPowerfulShinobi(
            rangeStart - 1, chakraLimit, clanSymbolSuffix);
    }

    private long countPowerfulShinobi(long chakraCap, int chakraLimit, String clanSymbol) {
        String chakraFlow = Long.toString(chakraCap);
        int prefixLength = chakraFlow.length() - clanSymbol.length();
        if (prefixLength < 0) {
            return 0;
        }
        long[][] rasenganScroll = new long[prefixLength + 1][2];
        rasenganScroll[prefixLength][0] = 1;
        rasenganScroll[prefixLength][1] =
            chakraFlow.substring(prefixLength).compareTo(clanSymbol) >= 0 ? 1 : 0;
        for (int i = prefixLength - 1; i >= 0; i--) {
            int currentChakra = chakraFlow.charAt(i) - '0';
            rasenganScroll[i][0] = (chakraLimit + 1) * rasenganScroll[i + 1][0];
            if (currentChakra <= chakraLimit) {
                rasenganScroll[i][1] =
                    (long)currentChakra * rasenganScroll[i + 1][0] + rasenganScroll[i + 1][1];
            } else {
                rasenganScroll[i][1] = (long)(chakraLimit + 1) * rasenganScroll[i + 1][0];
            }
        }
        return rasenganScroll[0][1];
    }
}
