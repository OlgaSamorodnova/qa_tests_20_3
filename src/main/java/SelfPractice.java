import java.math.BigInteger;
import java.util.Arrays;

public class SelfPractice {
    public static void main(String[] args) {
        task1();
        task2();
        System.out.println("1.3 Удаление из массива цифры 1: " + Arrays.toString(task3()));
    }

    public static void task1() {
//    Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
//    Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].
        int size = 10;
        double array[] = new double[size];
        double num = Math.random();

        for (int j = 0; j < size; j++) {
            array[j] = num;
        }

        System.out.println("1. Array: " + Arrays.toString(array));

        double maxNum = array[0];
        double minNum = array[0];
        double avg = 0;

        for (double i : array) {
            if (i > maxNum) {
                maxNum = i;
            }
            if (i < minNum) {
                minNum = i;
            }
            avg += i / array.length;
        }
        System.out.println("Maximum number = " + maxNum);
        System.out.println("Minimum number = " + minNum);
        System.out.println("Average number = " + avg);
// 1.1. Реализуйте алгоритм сортировки пузырьком для сортировки массива
        System.out.println("1.1 Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
            System.out.println(array[i]);

        }

    }

    public static void task2() {
// 1.2   Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
//    Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
        System.out.println("2. Prime numbers: ");
        for (int i = 2; i <= 100; i++) {
//            BigInteger bigInteger = BigInteger.valueOf(i);
//            boolean probablePrime = bigInteger.isProbablePrime(i);
//            if (probablePrime) {
//                System.out.println(i);
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }

        }
    }

    public static int[] task3() {
//  1.3      Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива (пропусков быть не должно).
        int array[] = {1,2,3,4,5,6,7,8,9,1,0,1};
        int num = 1;
        int x = 0;

        for (int i = 0; i< array.length; i++) {
           if (array[i] == num) {
               x++;
           }
           else {
               array[i-x] = array[i];
           }
            System.out.println(Arrays.toString(array));
            System.out.println(x);


        }
        return Arrays.copyOf(array, array.length - x);

    }
}


