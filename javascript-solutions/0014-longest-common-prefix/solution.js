/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
    if (strs === null || strs.length === 0) {
        return "";
    }
    let res = strs[0];
    for (let i = 0; i < strs.length; i++) {
        while (strs[i].indexOf(res) != 0) {
            res = res.substring(0, res.length - 1);
            if (res.length === 0) {
                return "";
            }
        }
    }
    return res;
};
