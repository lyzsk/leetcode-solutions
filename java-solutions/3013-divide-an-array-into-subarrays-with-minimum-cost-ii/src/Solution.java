import java.util.TreeMap;

/**
 * @author sichu huang
 * @since 2026/02/02 15:21
 */
public class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        Container cnt = new Container(k - 2);
        for (int i = 1; i < k - 1; i++) {
            cnt.add(nums[i]);
        }

        long res = cnt.sum() + nums[k - 1];
        for (int i = k; i < n; i++) {
            int j = i - dist - 1;
            if (j > 0) {
                cnt.erase(nums[j]);
            }
            cnt.add(nums[i - 1]);
            res = Math.min(res, cnt.sum() + nums[i]);
        }

        return res + nums[0];
    }
}

class Container {
    private final int k;
    private final TreeMap<Integer, Integer> st1;
    private final TreeMap<Integer, Integer> st2;
    private int st1Size;
    private int st2Size;
    private long sm;

    public Container(int k) {
        this.k = k;
        this.st1 = new TreeMap<>();
        this.st2 = new TreeMap<>();
        this.sm = 0;
        this.st1Size = 0;
        this.st2Size = 0;
    }

    private void removeOne(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }

    private void addOne(TreeMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    private void adjust() {
        while (st1Size < k && !st2.isEmpty()) {
            int x = st2.firstKey();
            addOne(st1, x);
            st1Size++;
            sm += x;
            removeOne(st2, x);
            st2Size--;
        }
        while (st1Size > k) {
            int x = st1.lastKey();
            addOne(st2, x);
            st2Size++;
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        }
    }

    public void add(int x) {
        if (!st2.isEmpty() && x >= st2.firstKey()) {
            addOne(st2, x);
            st2Size++;
        } else {
            addOne(st1, x);
            st1Size++;
            sm += x;
        }
        adjust();
    }

    public void erase(int x) {
        if (st1.containsKey(x)) {
            removeOne(st1, x);
            st1Size--;
            sm -= x;
        } else if (st2.containsKey(x)) {
            removeOne(st2, x);
            st2Size--;
        }
        adjust();
    }

    public long sum() {
        return sm;
    }
}