import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/04/07 17:32
 */
public class Robot {
    private final List<int[]> pos = new ArrayList<>();
    private final List<Integer> dir = new ArrayList<>();
    private final Map<Integer, String> toDir = new HashMap<>();
    private boolean moved = false;
    private int idx = 0;

    public Robot(int width, int height) {
        toDir.put(0, "East");
        toDir.put(1, "North");
        toDir.put(2, "West");
        toDir.put(3, "South");

        for (int i = 0; i < width; ++i) {
            pos.add(new int[] {i, 0});
            dir.add(0);
        }
        for (int i = 1; i < height; ++i) {
            pos.add(new int[] {width - 1, i});
            dir.add(1);
        }
        for (int i = width - 2; i >= 0; --i) {
            pos.add(new int[] {i, height - 1});
            dir.add(2);
        }
        for (int i = height - 2; i > 0; --i) {
            pos.add(new int[] {0, i});
            dir.add(3);
        }
        dir.set(0, 3);
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
        return pos.get(idx);
    }

    public String getDir() {
        if (!moved) {
            return "East";
        }
        return toDir.get(dir.get(idx));
    }
}
