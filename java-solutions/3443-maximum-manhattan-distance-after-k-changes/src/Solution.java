/**
 * @author sichu huang
 * @since 2025/06/20 16:00
 */
public class Solution {
    public int maxDistance(String s, int k) {
        int latitude = 0, longitude = 0, res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N':
                    latitude++;
                    break;
                case 'S':
                    latitude--;
                    break;
                case 'E':
                    longitude++;
                    break;
                case 'W':
                    longitude--;
                    break;
            }
            res = Math.max(res, Math.min(Math.abs(latitude) + Math.abs(longitude) + k * 2, i + 1));
        }
        return res;
    }
}
