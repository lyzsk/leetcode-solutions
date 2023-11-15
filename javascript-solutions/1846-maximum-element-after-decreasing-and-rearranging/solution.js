/**
 * @param {number[]} arr
 * @return {number}
 */
var maximumElementAfterDecrementingAndRearranging = function (arr) {
    arr.sort(function (a, b) {
        return a - b;
    });
    let n = arr.length;
    arr[0] = 1;
    for (let i = 1; i < n; i++) {
        if (arr[i] - arr[i - 1] > 1) {
            arr[i] = arr[i - 1] + 1;
        }
    }
    return arr[n - 1];
};
