package main.homework.lesson19.Test;

import org.junit.Assert;
import org.junit.Test;

import main.homework.lesson19.Sort;

public class SortTest {
    @Test
    public void testBubbleSort() {
        Assert.assertArrayEquals(Sort.bubbleSort(new int[] { 3, 4, 2, 1 }), new int[] { 1, 2, 3, 4 });
        Assert.assertArrayEquals(Sort.bubbleSort(new int[] { 0, 3, 2, 1 }), new int[] { 0, 1, 2, 3 });
        Assert.assertArrayEquals(Sort.bubbleSort(new int[] { 3, 3, 2, 1 }), new int[] { 1, 2, 3, 3 });
    }

    @Test
    public void testInsertSort() {
        Assert.assertArrayEquals(Sort.insertSort(new int[] { 3, 4, 2, 1 }), new int[] { 1, 2, 3, 4 });
        Assert.assertArrayEquals(Sort.insertSort(new int[] { 0, 3, 2, 1 }), new int[] { 0, 1, 2, 3 });
        Assert.assertArrayEquals(Sort.insertSort(new int[] { 3, 3, 2, 1 }), new int[] { 1, 2, 3, 3 });
    }

    @Test
    public void testSelectionSort() {
        Assert.assertArrayEquals(Sort.selectionSort(new int[] { 3, 4, 2, 1 }), new int[] { 1, 2, 3, 4 });
        Assert.assertArrayEquals(Sort.selectionSort(new int[] { 0, 3, 2, 1 }), new int[] { 0, 1, 2, 3 });
        Assert.assertArrayEquals(Sort.selectionSort(new int[] { 3, 3, 2, 1 }), new int[] { 1, 2, 3, 3 });
    }
}
