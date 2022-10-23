import java.util.HashMap;
import java.util.Map;

/**
 * zero, one, two, three, four, five, six, seven, eight, nine
 * <p>
 * e: 0, 1, 3, 5, 7, 8, 9
 * f: 4, 5
 * g: 8
 * h: 3, 8
 * i: 5, 6, 8, 9
 * n: 1, 7, 9
 * o: 0, 1, 2, 4
 * r: 0, 3, 4
 * s: 6, 7
 * t: 2, 3, 8
 * u: 4
 * v: 5, 7
 * w: 2
 * x: 6
 * z: 0
 * <p>
 * g, u, w, x, z 只出现在一个数字中, 即 0, 2, 4, 6, 8 出现次数
 * f, h, s 只出现在两个数字中:
 * f 4, 5, 已知 4 出现次数, 可以算出 5 出现次数
 * h 3, 8, 已知 8 出现次数, 可以算出 3 出现次数
 * s 6, 7, 已知 6 出现次数, 可以算出 7 出现次数
 * <p>
 * 还剩下 1, 9 出现次数
 * o 0, 1, 2, 4, 已知 0, 2, 4, 可以算出 1 出现次数
 * 9 可以通过 n, i, e 任一字符算出， 但是因为 n 在 9 中出现 2 次, e 在 3 中出现 2 次, 所以最好用 i 来算
 *
 * @author sichu
 * @date 2022/10/23
 **/
public class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int[] cnt = new int[10];
        cnt[0] = map.getOrDefault('z', 0);
        cnt[2] = map.getOrDefault('w', 0);
        cnt[4] = map.getOrDefault('u', 0);
        cnt[6] = map.getOrDefault('x', 0);
        cnt[8] = map.getOrDefault('g', 0);

        cnt[3] = map.getOrDefault('h', 0) - cnt[8];
        cnt[5] = map.getOrDefault('f', 0) - cnt[4];
        cnt[7] = map.getOrDefault('s', 0) - cnt[6];

        cnt[1] = map.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = map.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                res.append((char)(i + '0'));
            }
        }
        return res.toString();
    }
}
