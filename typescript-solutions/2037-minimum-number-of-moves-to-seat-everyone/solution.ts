function minMovesToSeat(seats: number[], students: number[]): number {
    let res: number = 0;
    seats.sort((a, b) => a - b);
    students.sort((a, b) => a - b);
    for (let i = 0; i < seats.length; i++) {
        res += Math.abs(seats[i] - students[i]);
    }
    return res;
}
