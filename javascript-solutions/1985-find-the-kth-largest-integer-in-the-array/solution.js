/**
 * @param {string[]} nums
 * @param {number} k
 * @return {string}
 */
var kthLargestNumber = function (nums, k) {
    const arr = nums.map((item) => BigInt(item));
    arr.sort((o1, o2) => {
        return o2 - o1 >= 0 ? 1 : -1;
    });
    return String(arr[k - 1]);
};
