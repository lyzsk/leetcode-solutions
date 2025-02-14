import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/02/14 20:45
 */
public class ProductOfNumbers {
    private List<Integer> pre;
    private int len;

    public ProductOfNumbers() {
        pre = new ArrayList<>();
        pre.add(1);
        len = 0;
    }

    public void add(int num) {
        if (num == 0) {
            pre = new ArrayList<>();
            pre.add(1);
            len = 0;
        } else {
            pre.add(pre.get(len) * num);
            ++len;
        }
    }

    public int getProduct(int k) {
        if (len < k) {
            return 0;
        }
        return pre.get(len) / pre.get(len - k);
    }
}
