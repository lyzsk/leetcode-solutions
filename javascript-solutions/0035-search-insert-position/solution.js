/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
    const n = nums.length;
    let left = 0;
    let right = n - 1;
    while (left < right) {
        let mid = left + ((right - left) >> 1);
        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    if (left === n - 1 && nums[left] < target) {
        return n;
    }
    return left;
};
