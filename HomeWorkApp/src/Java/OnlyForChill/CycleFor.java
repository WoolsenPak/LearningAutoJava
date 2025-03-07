package OnlyForChill;

import java.util.Scanner;

public class CycleFor {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Enumeration();

    }

    public static void Enumeration () {

        System.out.print("Введите число n: ");
        int num = sc.nextInt();
        int sum = 0;
            if (num > 0) {
                for (int i = 1 ; i <= num; i++) {
                    sum = sum + i;
                }
                System.out.println("Сумма чисел от 1 до " + num + ": " + sum);
            } else {
                System.out.println("Ошибка: введите положительное число!");
            }


    }
}
