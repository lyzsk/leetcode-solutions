/**
 * @author sichu
 * @date 2023/01/08
 **/
public class DataStream {
    private final int value;
    private final int k;
    private int count;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (num == value) {
            ++count;
        } else {
            count = 0;
        }
        return count >= k;
    }
}
