/**
 * @author sichu
 * @date 2022/11/14
 **/
public class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] sNum = new int[128];//s中窗口滑动的字符频数数组
        int[] tNum = new int[128];//t中的字符频数数组
        //字符t当中出现的字符的个数
        for (char c : charArrayT) {
            tNum[c]++;
        }

        int num = 0;//滑动窗口内包含了多少t的元素
        int minLen = sLen + 1;//最小子串
        int begin = 0;//起始下标

        int left = 0;
        int right = 0;

        while (right < sLen) {
            //如右边界的元素没在t中出现的时候
            if (tNum[charArrayS[right]] == 0) {
                right++;
                continue;
            }
            //在s中字符出现的个数小于在t中字符出现的个数，那么num++
            if (sNum[charArrayS[right]] < tNum[charArrayS[right]]) {
                num++;
            }
            //让程序看见下一个字符
            sNum[charArrayS[right]]++;
            right++;
            //s中包含了t中所有的字符
            while (num == tLen) {
                //当前滑动窗口的子串长度小于最小的子串长度
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                //左边界没在t中出现的时候
                if (tNum[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }
                //当前窗口看到的元素个数等于在t中左边界出现的元素个数
                if (sNum[charArrayS[left]] == tNum[charArrayS[left]]) {
                    num--;
                }
                sNum[charArrayS[left]]--;
                left++;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
