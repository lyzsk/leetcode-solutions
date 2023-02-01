import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/02/01
 **/
public class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> Integer.compare(o2[k], o1[k]));
        return score;
    }
}
