function minIncrementForUnique(nums: number[]): number {
    nums.sort((a, b) => a - b);
    let res = 0;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] <= nums[i - 1]) {
            res += nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i - 1] + 1;
        }
    }
    return res;
}
