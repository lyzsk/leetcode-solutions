/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function (chars) {
    let i = 0;
    let res = 0;
    while (i < chars.length) {
        let j = i + 1;
        while (j < chars.length && chars[i] == chars[j]) {
            ++j;
        }
        chars[res++] = chars[i];
        let cnt = j - i;
        if (cnt > 1) {
            let str = cnt + "";
            for (let k = 0; k < str.length; k++) {
                chars[res++] = str[k];
            }
        }
        i = j;
    }
    return res;
};
