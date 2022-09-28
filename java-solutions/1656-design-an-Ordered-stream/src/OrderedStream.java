import java.util.ArrayList;
import java.util.List;

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 *
 * @author sichu
 * @date 2022/08/16
 **/
public class OrderedStream {

    private final String[] stream;
    private int ptr;

    public OrderedStream(int n) {
        this.stream = new String[n + 1];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr]);
            ++ptr;
        }
        return res;
    }
}