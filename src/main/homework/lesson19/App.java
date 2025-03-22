package main.homework.lesson19;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.homework.lesson19.Star.Buyer;
import main.homework.lesson19.Star.Manufacturer;
import main.homework.lesson19.Star.Store;

public class App {
    // Задача 1:
    // Пользователь вводит с клавиатуры значение в массив. После чего запускаются
    // два потока. Первый поток находит максимум в массиве, второй — минимум.
    // Результаты вычислений возвращаются в метод main().
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            InterruptedException {
        // List<Integer> list = new ArrayList<>();
        // try (Scanner scaner = new Scanner(System.in)) {
        // System.out.println("Введите числа в массив. Ввод не числа - окончание
        // ввода.");

        // while (scaner.hasNextInt()) {
        // int val = scaner.nextInt();
        // list.add(val);
        // }
        // }

        // int[] arr = list.stream().mapToInt(i -> (int) i).toArray();

        // MyThread threadFirst = new MyThread(arr);
        // MyThread threadSecond = new MyThread(arr);
        // threadFirst.start();
        // threadSecond.start();
        // System.out.println("min = " + threadFirst.seachMin("selectionSort")); //
        // передаем метод для сортировки массива
        // System.out.println("max = " + threadSecond.seachMax("selectionSort"));

        // Задача 2:
        // Сортировка массива цифр в нескольких потоках различными алгоритмами:
        //  сортировка вставками;
        //  сортировка выбором;
        //  сортировка пузырьком.
        // Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
        // результат отсортированных массивов в консоль.

        int[] arrayForSort = new int[] { 3, 5, 7, 1, 4, 11, 12, 2, 6, 9, 10, 8, 7 };

        MyThread first = new MyThread(arrayForSort);
        MyThread second = new MyThread(arrayForSort);
        MyThread third = new MyThread(arrayForSort);

        first.start();
        second.start();
        third.start();

        int[] insertSort = first.sort("insertSort");
        int[] selectionSort = second.sort("selectionSort");
        int[] bubbleSort = third.sort("bubbleSort");

        System.out.println("insertSort    " + Arrays.toString(insertSort) + "\nselectionSort "
                + Arrays.toString(selectionSort) + "\nbubbleSort    "
                + Arrays.toString(bubbleSort));

        // Задача *:
        // Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так
        // чтобы
        // производитель произвел 5 единиц продукта, а покупатель их купил. Пока
        // производитель
        // не произвел продукт, покупатель не может его купить. При этом одновременно в
        // магазине
        // может находиться не более 3 товаров.
        Store store = new Store();
        Manufacturer manufacturer = new Manufacturer(store);
        Buyer buyer = new Buyer(store);
        Thread manfcThrd = new Thread(manufacturer);
        Thread buyerThrd = new Thread(buyer);
        manfcThrd.start();
        manfcThrd.join();
        buyerThrd.start();
    }
}
