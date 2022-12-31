/**
 * @param {number[]} seats
 * @param {number[]} students
 * @return {number}
 */
var minMovesToSeat = function (seats, students) {
    let res = 0;
    seats.sort((o1, o2) => o1 - o2);
    students.sort((o1, o2) => o1 - o2);
    for (let i = 0; i < seats.length; i++) {
        res += Math.abs(seats[i] - students[i]);
    }
    return res;
};
