/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    let p = 0;
    let q = 0;
    let r = 1;
    for (let i = 1; i <= n; i++) {
        p = q;
        q = r;
        r = p + q;
    }
    return r;
};
