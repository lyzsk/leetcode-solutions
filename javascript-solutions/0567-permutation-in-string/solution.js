/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function (s1, s2) {
    const n = s1.length;
    const m = s2.length;
    if (n > m) {
        return false;
    }
    const cnt = new Array(26).fill(0);
    for (let i = 0; i < n; i++) {
        cnt[s1.charCodeAt(i) - "a".charCodeAt(0)]--;
    }
    let left = 0;
    for (let right = 0; right < m; right++) {
        const x = s2.charCodeAt(right) - "a".charCodeAt(0);
        cnt[x]++;
        while (cnt[x] > 0) {
            cnt[s2.charCodeAt(left) - "a".charCodeAt(0)]--;
            left++;
        }
        if (right - left + 1 === n) {
            return true;
        }
    }
    return false;
};
