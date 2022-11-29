import java.util.*;

/**
 * @author sichu
 * @date 2022/11/29
 **/
public class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> indicies;
    private Random random;

    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.indicies = new HashMap<>(16);
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (indicies.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indicies.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indicies.containsKey(val)) {
            return false;
        }
        int index = indicies.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indicies.put(last, index);
        nums.remove(nums.size() - 1);
        indicies.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
