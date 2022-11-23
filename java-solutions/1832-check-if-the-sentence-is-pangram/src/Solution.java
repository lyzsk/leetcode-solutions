/**
 * @author sichu
 * @date 2022/11/23
 **/
public class Solution {
    public boolean checkIfPangram(String sentence) {
        // Set<Integer> set = new HashSet<>(26);
        // for (char ch : sentence.toCharArray()) {
        //     int n = ch - 'a';
        //     if (n >= 0 && n < 26) {
        //         if (set.add(n)) {
        //             if (set.size() == 26) {
        //                 return true;
        //             }
        //         }
        //     }
        // }
        // return false;
        for (int i = 0; i < 26; i++) {
            char cur = (char)(i + 'a');
            if (sentence.indexOf(cur) == -1) {
                return false;
            }
        }
        return true;
    }
}
