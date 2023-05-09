/**
 * @author sichu
 * @date 2023/05/09
 **/
public class Solution {
    private static final char UNKNOW = '?';

    public int countTime(String time) {
        int hrCnt = 0;
        int minCnt = 0;
        for (int i = 0; i < 24; i++) {
            int fstHr = i / 10;
            int secHr = i % 10;
            if ((time.charAt(0) == '0' + fstHr || time.charAt(0) == UNKNOW) && (time.charAt(1) == '0' + secHr
                || time.charAt(1) == UNKNOW)) {
                ++hrCnt;
            }
        }
        for (int i = 0; i < 60; i++) {
            int fstMin = i / 10;
            int secMin = i % 10;
            if ((time.charAt(3) == '0' + fstMin || time.charAt(3) == UNKNOW) && (time.charAt(4) == '0' + secMin
                || time.charAt(4) == UNKNOW)) {
                ++minCnt;
            }
        }
        return hrCnt * minCnt;
    }
}
