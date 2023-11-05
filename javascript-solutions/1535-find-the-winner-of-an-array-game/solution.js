/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var getWinner = function (arr, k) {
    if (k === 1) {
        return Math.max(arr[0], arr[1]);
    }
    const n = arr.length;
    if (k >= n) {
        return Math.max(...arr);
    }
    let curWinner = arr[0];
    let winCnt = 0;
    for (let i = 1; i < n; i++) {
        if (curWinner > arr[i]) {
            winCnt++;
        } else {
            curWinner = arr[i];
            winCnt = 1;
        }
        if (winCnt === k) {
            return curWinner;
        }
    }
    return curWinner;
};
