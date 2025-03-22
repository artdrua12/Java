package main.homework.lesson19;

public class Sort {
    public static int[] insertSort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int previous = array[i];
            for (j = i; j > 0; j--) {
                if (previous < array[j - 1]) {
                    array[j] = array[j - 1];
                    array[j - 1] = previous;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i; // pos - индекс наименьшего элемента
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
        return array;
    }

}
