import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/12/02
 **/
public class Solution {
    // public List<Integer> splitIntoFibonacci(String S) {
    //     List<Integer> res = new ArrayList<>();
    //     backtrack(S.toCharArray(), res, 0);
    //     return res;
    // }
    //
    // public boolean backtrack(char[] digit, List<Integer> res, int index) {
    //     //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
    //     //F.length >= 3
    //     if (index == digit.length && res.size() >= 3) {
    //         return true;
    //     }
    //     for (int i = index; i < digit.length; i++) {
    //         //两位以上的数字不能以0开头
    //         //如果只是0 就不用跳出
    //         //请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
    //         if (digit[index] == '0' && i > index) {
    //             break;
    //         }
    //         //截取字符串转化为数字,注意越界判断
    //         long num = subDigit(digit, index, i + 1);
    //         //如果截取的数字大于int的最大值，则终止截取
    //         if (num > Integer.MAX_VALUE) {
    //             break;
    //         }
    //         int size = res.size();
    //         //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
    //         if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
    //             //注意是break
    //             break;
    //         }
    //         if (size >= 2 && num < res.get(size - 1) + res.get(size - 2)) {
    //             //注意是continue
    //             //小于的话还要继续下一个循环，不能break
    //             continue;
    //         }
    //         //ps上面两个判断可以合并成一个，但是会多循环，也能通过
    //         //if (size >= 2 && num != res.get(size - 1) + res.get(size - 2)) {
    //         //               continue;
    //         //                }
    //         //把数字num添加到集合res中
    //         //走到这里res.size() = 0或者1，或者前两个结果相加等于num
    //         res.add((int)num);
    //         //如果找到了就直接返回
    //         if (backtrack(digit, res, i + 1)) {
    //             return true;
    //         }
    //         //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
    //         res.remove(res.size() - 1);
    //
    //     }
    //     return false;
    // }
    //
    // //相当于截取字符串S中的子串然后转换为十进制数字
    // private long subDigit(char[] digit, int start, int end) {
    //     long res = 0;
    //     for (int i = start; i < end; i++) {
    //         res = res * 10 + digit[i] - '0';
    //     }
    //     return res;
    // }
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        backtrack(res, num.toCharArray(), 0);
        return res;
    }

    private boolean backtrack(List<Integer> res, char[] digits, int index) {
        if (index == digits.length && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < digits.length; i++) {
            if (digits[index] == '0' && i > index) {
                break;
            }
            long num = 0;
            for (int j = index; j < i + 1; j++) {
                num = num * 10 + digits[j] - '0';
            }
            int size = res.size();
            if (size >= 2 && num > res.get(size - 2) + res.get(size - 1)) {
                break;
            }
            if (size >= 2 && num < res.get(size - 2) + res.get(size - 1)) {
                continue;
            }
            if (size < 2 || num == res.get(size - 2) + res.get(size - 1)) {
                res.add((int)num);
                if (backtrack(res, digits, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
