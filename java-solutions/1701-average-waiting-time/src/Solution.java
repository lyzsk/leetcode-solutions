/**
 * @author sichu huang
 * @date 2024/07/09
 **/
public class Solution {
    public double averageWaitingTime(int[][] customers) {
        int moment = 0;
        double wait = 0;
        for (int[] customer : customers) {
            int timei = customer[1];
            int arrival = customer[0];
            if (arrival > moment) {
                wait += timei;
                moment = arrival + timei;
            } else {
                timei = customer[1];
                arrival = customer[0];
                wait += moment - arrival + timei;
                moment += timei;
            }
        }
        return wait / customers.length;
    }
}
