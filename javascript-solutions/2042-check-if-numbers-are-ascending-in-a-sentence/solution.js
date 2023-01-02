/**
 * @param {string} s
 * @return {boolean}
 */
var areNumbersAscending = function (s) {
    let i = 0;
    let pre = 0;
    while (i < s.length) {
        if (isDigit(s[i])) {
            let cur = 0;
            while (i < s.length && isDigit(s[i])) {
                cur = cur * 10 + s[i].charCodeAt() - "0".charCodeAt();
                ++i;
            }
            if (cur <= pre) {
                return false;
            }
            pre = cur;
        } else {
            ++i;
        }
    }
    return true;
};

const isDigit = (ch) => {
    return parseInt(ch).toString() === "NaN" ? false : true;
};
