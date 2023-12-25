/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
    const n = s.length;
    let a = 0;
    let b = 1;
    let c = 0;
    for (let i = 1; i <= n; i++) {
        c = 0;
        if (s.charAt(i - 1) !== "0") {
            c += b;
        }
        if (
            i > 1 &&
            s.charAt(i - 2) !== "0" &&
            parseInt(s.charAt(i - 2)) * 10 + parseInt(s.charAt(i - 1)) <= 26
        ) {
            c += a;
        }
        a = b;
        b = c;
    }
    return c;
};
