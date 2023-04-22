/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function (grid) {
    const m = grid.length;
    const n = grid[0].length;
    const dfs = (x, y) => {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || grid[x][y] === 0) {
            return 1;
        }
        if (grid[x][y] === 2) {
            return 0;
        }
        grid[x][y] = 2;
        let res = 0;
        res += dfs(x - 1, y);
        res += dfs(x + 1, y);
        res += dfs(x, y - 1);
        res += dfs(x, y + 1);
        return res;
    };
    let res = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                res += dfs(i, j);
            }
        }
    }
    return res;
};
