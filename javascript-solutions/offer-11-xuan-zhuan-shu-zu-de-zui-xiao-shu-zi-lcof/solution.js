/**
 * @param {number[]} numbers
 * @return {number}
 */
var minArray = function (numbers) {
    let left = 0;
    let right = numbers.length - 1;
    while (left < right) {
        const mid = left + ((right - left) >> 1);
        if (numbers[mid] == numbers[right]) {
            right -= 1;
        } else if (numbers[mid] > numbers[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return numbers[left];
};
