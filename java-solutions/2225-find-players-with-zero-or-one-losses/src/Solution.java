import java.util.*;

/**
 * @author sichu
 * @date 2022/11/28
 **/
public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loserMap = new TreeMap<>();
        Set<Integer> winnerSet = new TreeSet<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (loserMap.containsKey(loser)) {
                loserMap.put(loser, loserMap.get(loser) + 1);
            } else {
                loserMap.put(loser, 1);
            }
            winnerSet.add(winner);
        }
        List<Integer> loserList = new ArrayList<>();
        List<Integer> winnerList = new ArrayList<>();
        for (Integer loser : loserMap.keySet()) {
            if (loserMap.get(loser) == 1) {
                loserList.add(loser);
            }
        }
        for (Integer winner : winnerSet) {
            if (!loserMap.containsKey(winner)) {
                winnerList.add(winner);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(winnerList);
        res.add(loserList);
        return res;
    }
}
