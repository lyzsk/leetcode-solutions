/**
 * @author sichu
 * @date 2022/12/02
 **/
public class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        while (b <= k) {
            int c = a + b;
            a = b;
            b = c;
        }
        return findMinFibonacciNumbers(k - a) + 1;
    }
    // public int findMinFibonacciNumbers(int k) {
    //     int res = 0;
    //     List<Integer> list = new ArrayList<>();
    //     list.add(1);
    //     int a = 1;
    //     int b = 1;
    //     while (a + b <= k) {
    //         int c = a + b;
    //         list.add(c);
    //         a = b;
    //         b = c;
    //     }
    //     for (int i = list.size() - 1; i >= 0; i--) {
    //         int num = list.get(i);
    //         if (num <= k) {
    //             k -= num;
    //             ++res;
    //             if (k == 0) {
    //                 break;
    //             }
    //         }
    //     }
    //     return res;
    // }
}
