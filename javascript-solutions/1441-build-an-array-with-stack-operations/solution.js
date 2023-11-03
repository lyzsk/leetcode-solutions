/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function (target, n) {
    let res = [];
    let cur = 1;
    let idx = 0;
    while (cur <= n && idx < target.length) {
        let num = target[idx];
        if (num == cur) {
            res.push("Push");
            cur++;
            idx++;
        } else {
            res.push("Push");
            res.push("Pop");
            cur++;
        }
    }
    return res;
};
