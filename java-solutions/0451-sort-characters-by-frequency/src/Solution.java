import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/12/03
 **/
public class Solution {
    public String frequencySort(String s) {
        int[][] freq = new int[128][2];
        for (int i = 0; i < 128; i++) {
            freq[i][0] = i;
        }
        for (char ch : s.toCharArray()) {
            ++freq[ch][1];
        }
        Arrays.sort(freq, (o1, o2) -> o2[1] - o1[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            while (freq[i][1] > 0) {
                sb.append((char)freq[i][0]);
                --freq[i][1];
            }
        }
        return sb.toString();
    }
    // public String frequencySort(String s) {
    //     Map<Character, Integer> freq = new HashMap<>(36);
    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    //     }
    //     List<Character> list = new ArrayList<>(freq.keySet());
    //     Collections.sort(list, (o1, o2) -> freq.get(o2) - freq.get(o1));
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < list.size(); i++) {
    //         char ch = list.get(i);
    //         int frequency = freq.get(ch);
    //         for (int j = 0; j < frequency; j++) {
    //             sb.append(ch);
    //         }
    //     }
    //     return sb.toString();
    // }
}
