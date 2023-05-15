import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/05/14
 **/
public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Integer[] temp = new Integer[n];
        int maxv = 0;
        for (int i = 0; i < n; i++) {
            temp[i] = barcodes[i];
            maxv = Math.max(maxv, barcodes[i]);
        }
        int[] cnt = new int[maxv + 1];
        for (int barcode : barcodes) {
            ++cnt[barcode];
        }
        Arrays.sort(temp, (o1, o2) -> cnt[o1] == cnt[o2] ? Integer.compare(o2, o1) : Integer.compare(cnt[o2], cnt[o1]));
        int[] res = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i += 2) {
            res[i] = temp[idx++];
        }
        for (int i = 1; i < n; i += 2) {
            res[i] = temp[idx++];
        }
        return res;
    }
}
