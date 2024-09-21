function shortestPalindrome(s: string): string {
    const count = kmp(s.split("").reverse().join(""), s);
    return s.substring(count).split("").reverse().join("") + s;
}

function kmp(reverse: string, origin: string): number {
    const str = origin + "." + reverse;
    const arr: number[] = new Array(str.length).fill(0);
    let i = 1;
    let left = 0;

    while (i < str.length) {
        if (str.charAt(i) === str.charAt(left)) {
            left++;
            arr[i++] = left;
        } else {
            if (left > 0) {
                left = arr[--left];
            } else {
                arr[i++] = 0;
            }
        }
    }
    return arr[str.length - 1];
}
