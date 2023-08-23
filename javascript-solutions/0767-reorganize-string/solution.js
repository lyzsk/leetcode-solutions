/**
 * @param {string} s
 * @return {string}
 */
var reorganizeString = function (s) {
    let arr = s.split("");
    let n = s.length;
    let cnt = new Array(26).fill(0);
    for (let ch of arr) {
        ++cnt[ch.charCodeAt(0) - "a".charCodeAt(0)];
    }
    let maxIdx = 0;
    for (let i = 0; i < 26; i++) {
        if (cnt[i] > cnt[maxIdx]) {
            maxIdx = i;
        }
    }
    if (cnt[maxIdx] > (n + 1) >> 1) {
        return "";
    }
    let res = new Array(n).fill("");
    let i = 0;
    while (cnt[maxIdx]-- > 0) {
        res[i] = String.fromCharCode("a".charCodeAt(0) + maxIdx);
        i += 2;
    }
    for (let j = 0; j < 26; j++) {
        while (cnt[j]-- > 0) {
            if (i >= n) {
                i = 1;
            }
            res[i] = String.fromCharCode("a".charCodeAt(0) + j);
            i += 2;
        }
    }
    return res.join("");
};
