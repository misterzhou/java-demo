package org.guojing.core;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created at: 2016-05-12
 *
 * @author guojing
 */
public class QuickSort {

    @Test
    public void testQuickSort() {
        //int[] array = new int[]{11, 5, 1, 6, 2, 3, 8};
        int[] array = new int[]{8, 2};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    void quicksort(int[] array, int s, int e) {
        if (s < e) {
            int p = partition(array, s, e);
            quicksort(array, s, p - 1);
            quicksort(array, p + 1, e);
        }
    }

    int partition(int[] array, int s, int e) {
        int x = array[e];
        int i = s - 1;
        for (int j = s; j <= e - 1; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, e);
        return i + 1;
    }

    void swap(int[] array, int x, int y) {
        if (array[x] == array[y]) {
            return;
        }
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
