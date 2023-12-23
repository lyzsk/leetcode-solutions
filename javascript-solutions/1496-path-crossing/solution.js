/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function (path) {
    let x = 0;
    let y = 0;
    const visited = new Set();
    visited.add(`${x}:${y}`);
    for (let ch of path) {
        if (ch === "N") {
            ++y;
        } else if (ch === "S") {
            --y;
        } else if (ch === "E") {
            ++x;
        } else {
            --x;
        }
        let point = `${x}:${y}`;
        if (visited.has(point)) {
            return true;
        }
        visited.add(point);
    }
    return false;
};
