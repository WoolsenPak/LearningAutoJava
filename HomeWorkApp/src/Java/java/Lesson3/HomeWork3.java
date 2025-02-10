package Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork3 {



    public static void main(String[] args) {
        System.out.println("\n \n===== начало домашки ===== ");

        System.out.println("\n-----------------------------------");
        System.out.println("1. Выводим целочисленный массив с изменёнными 0 и 1:");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Массив до изменений: " + Arrays.toString(array1) + " ");
        arrayWithTwoNumbers(array1);
        System.out.print("\nМассив с изменениями: " + Arrays.toString(array1) + " ");


        System.out.println("\n-----------------------------------");
        System.out.println("\n2. Массив с длиной 100:");
        int[] array2 = new int[100];
        arrayWith100Numbers(array2);
        printArray(" ", array2);

        System.out.println("\n-----------------------------------");
        System.out.println("\n3. Массив, в котором числа < 6 умножаются на 2:");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray("Массив до изменений: ", array3);
        arrayWithMultiplication(array3);
        printArray("\nМассив с изменениями: ", array3);

        System.out.println("\n-----------------------------------");
        System.out.println("\n4. Квадратный массив, где по диагоналям единицы:");
        int size = 5;
        int[][] array4 = new int[size][size];
        squareArrayWithFilledDiagonals(array4);
        printTwoArrays(array4);

        System.out.println("\n-----------------------------------");
        System.out.println("\n5. Массив с двумя аргументами на входе:");
        printArray(" ", methodWithTwoArguments(3, 1));

        System.out.println("\n-----------------------------------");
        System.out.println("\n6. Массив с найденными минимальными и максимальными элементами:");
        int[] array6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printArray(" ", array6);
        System.out.println("\nМинимальный элемент массива: " + arrayWithMinElements (array6));
        System.out.println("Максимальный элемент массива: " + arrayWithMaxElements (array6));

        System.out.println("\n \n===== конец домашки ===== ");
    }

    //  1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void arrayWithTwoNumbers(int[] array1) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else
                array1[i] = 0;
        }
    }

    //  2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void arrayWith100Numbers(int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
    }

    //  3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static int arrayWithMultiplication(int[] array3) {
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        return array3[0];
    }

    //  4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]
    public static void squareArrayWithFilledDiagonals(int [][] array4) {
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++) {
                if (i == j || i + j == array4.length - 1) {
                    array4[i][j] = 1;
                }
            }
        }
    }

    // 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static int[] methodWithTwoArguments(int len, int initialValue) {
        int[] array5 = new int[len];
        for (int i = 0; i < len; i++) {
            array5[i] = initialValue;
        }
        return array5;
    }

    // 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы;
    public static int arrayWithMinElements(int[] array6) {
        int min = array6[0];
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] < min) {
                min = array6[i];
            }
        }
        return min;
    }

    public static int arrayWithMaxElements(int[] array6) {
        int max = array6[0];
        for (int i = 0; i < array6.length; i++) {
        if (array6[i] > max) {
                max = array6[i];
            }
        }
        return max;
    }

    public static void printArray(String message, int[] array) {
        System.out.print(message);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i] + " ");
        }
        System.out.println();
    }

    public static void printTwoArrays(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}



