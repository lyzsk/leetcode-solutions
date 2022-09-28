/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    let range = new Array(2).fill(0);
    let arr = s.split("");
    for (let left = 0; left < s.length; left++) {
        left = findLongest(arr, left, range);
    }
    return s.substring(range[0], range[1] + 1);
};

var findLongest = function (arr, left, range) {
    let right = left;
    while (right < arr.length - 1 && arr[right] === arr[right + 1]) {
        ++right;
    }
    let res = right;
    while (
        left > 0 &&
        right < arr.length - 1 &&
        arr[left - 1] === arr[right + 1]
    ) {
        --left;
        ++right;
    }
    if (right - left > range[1] - range[0]) {
        range[0] = left;
        range[1] = right;
    }
    return res;
};
