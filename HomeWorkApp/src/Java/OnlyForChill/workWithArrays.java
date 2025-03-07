package OnlyForChill;

import java.util.Scanner;

public class workWithArrays {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент " + (i+1) + ": ");
            arr[i] = sc.nextInt();
            sum += arr[i];

            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
    }




}
