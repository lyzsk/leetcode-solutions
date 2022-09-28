/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    let map = new Map();
    let res = 0;
    for (let left = 0, right = 0; right < s.length; right++) {
        const ch = s.charAt(right);
        if (map.has(ch)) {
            left = Math.max(left, map.get(ch) + 1);
        }
        map.set(ch, right);
        res = Math.max(res, right - left + 1);
    }
    return res;
};
