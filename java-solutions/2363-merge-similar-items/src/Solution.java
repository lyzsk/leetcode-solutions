import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = new int[1001];
        for (int i = 0; i < items1.length; i++) {
            arr[items1[i][0]] += items1[i][1];
        }
        for (int i = 0; i < items2.length; i++) {
            arr[items2[i][0]] += items2[i][1];
        }
        for (int i = 0; i <= 1000; i++) {
            if (arr[i] != 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}
