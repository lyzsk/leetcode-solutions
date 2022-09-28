/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
    let freq = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        let ch = s.charAt(i);
        ++freq[ch.charCodeAt() - 97];
    }
    for (let i = 0; i < s.length; i++) {
        let ch = s.charAt(i);
        if (freq[ch.charCodeAt() - 97] == 1) {
            return i;
        }
    }
    return -1;
};
