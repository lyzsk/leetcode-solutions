/**
 * @param {number[][]} points
 * @return {number}
 */
var minAreaRect = function (points) {
    if (points.length < 4) {
        return 0;
    }
    let res;
    for (let i = 0; i < points.length; i++) {
        const [x1, y1] = points[i];
        for (let j = i + 1; j < points.length; j++) {
            const [x2, y2] = points[j];
            if (x1 === x2 || y1 === y2) {
                continue;
            }
            const area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
            if (area > res) {
                continue;
            }
            const needs = points.filter(
                ([x, y]) => (x === x1 && y === y2) || (x === x2 && y === y1)
            );
            if (needs.length < 2) {
                continue;
            }
            res = area;
        }
    }
    return res || 0;
};
