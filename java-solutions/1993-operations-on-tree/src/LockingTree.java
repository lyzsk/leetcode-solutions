import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu
 * @date 2023/09/23
 **/
public class LockingTree {
    private int[] parent;
    private int[] lockNodeUser;
    private List<Integer>[] children;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        this.lockNodeUser = new int[n];
        Arrays.fill(lockNodeUser, -1);
        this.children = new List[n];
        for (int i = 0; i < n; i++) {
            this.children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parent[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (lockNodeUser[num] == -1) {
            lockNodeUser[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lockNodeUser[num] == user) {
            lockNodeUser[num] = -1;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        boolean res = lockNodeUser[num] == -1 && !hadLockedAncestor(num) && checkAndUnlockDescendant(num);
        if (res) {
            lockNodeUser[num] = user;
        }
        return res;
    }

    private boolean checkAndUnlockDescendant(int num) {
        boolean res = lockNodeUser[num] != -1;
        lockNodeUser[num] = -1;
        for (int children : children[num]) {
            res |= checkAndUnlockDescendant(children);
        }
        return res;
    }

    private boolean hadLockedAncestor(int num) {
        num = parent[num];
        while (num != -1) {
            if (lockNodeUser[num] != -1) {
                return true;
            }
            num = parent[num];
        }
        return false;
    }
}
