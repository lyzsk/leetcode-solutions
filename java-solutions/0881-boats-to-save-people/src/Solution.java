import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/05/04
 **/
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (people[j] + people[i] <= limit) {
                ++i;
            }
            --j;
            ++boats;
        }
        return boats;
    }
}
