/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function (s, t) {
    const cntS = new Array(26).fill(0);
    const cntT = new Array(26).fill(0);

    for (let ch of s) {
        ++cntS[ch.charCodeAt(0) - "a".charCodeAt(0)];
    }
    for (let ch of t) {
        ++cntT[ch.charCodeAt(0) - "a".charCodeAt(0)];
    }
    let res = 0;
    for (let i = 0; i < 26; i++) {
        res += Math.abs(cntS[i] - cntT[i]);
    }
    return res >> 1;
};
