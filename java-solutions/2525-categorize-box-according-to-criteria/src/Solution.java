/**
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        boolean heavy = false;
        long volumn = (long)length * width * height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || volumn >= 1000000000) {
            bulky = true;
        }
        if (mass >= 100) {
            heavy = true;
        }
        if (bulky && heavy) {
            return "Both";
        } else if (bulky == false && heavy == false) {
            return "Neither";
        } else if (bulky == true && heavy == false) {
            return "Bulky";
        } else {
            return "Heavy";
        }
    }
}
