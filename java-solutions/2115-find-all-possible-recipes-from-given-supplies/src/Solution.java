import java.util.*;

/**
 * @author sichu huang
 * @since 2025/03/21 08:53
 */
public class Solution {
    private final Set<String> set = new HashSet<>();

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
        String[] supplies) {
        boolean[] used = new boolean[recipes.length];
        List<String> res = new ArrayList<>();
        Collections.addAll(set, supplies);
        while (true) {
            int inc = 0;
            for (int i = 0; i < recipes.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (canMake(ingredients.get(i))) {
                    used[i] = true;
                    set.add(recipes[i]);
                    res.add(recipes[i]);
                    inc++;
                }
            }
            if (inc == 0) {
                break;
            }
        }
        return res;
    }

    private boolean canMake(List<String> ingredient) {
        for (String s : ingredient) {
            if (!set.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
