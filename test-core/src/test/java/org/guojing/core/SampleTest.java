package org.guojing.core;

import org.junit.Test;

/**
 * Created at: 2016-04-20
 *
 * @author guojing
 */
public class SampleTest {

    @Test
    public void testPermutation() {
        String str = "abc";
        str = "aaaa";
        char[] chars = str.toCharArray();
        permutation(chars, 0);
    }

    //字符串全排列
    private void permutation(char[] str, int curIdx) {
        int len = str.length;
        if (curIdx == len - 1) {
            System.out.println(str);
        } else {
            for (int i = curIdx; i < len; i++) {
                if (!needSwap(str, curIdx, i)) {
                    continue;
                }
                /*if (curIdx != i && str[curIdx] == str[i]) {
                    continue;
                }*/
                swap(str, curIdx, i);
                permutation(str, curIdx + 1);
                swap(str, curIdx, i);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        if (str[i] == str[j]) {
            return;
        }
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    private boolean needSwap(char[] str, int start, int end) {
        for (int i = start; i < end; i++) {
            if (str[i] == str[end]) {
                return false;
            }
        }
        return true;
    }
}
