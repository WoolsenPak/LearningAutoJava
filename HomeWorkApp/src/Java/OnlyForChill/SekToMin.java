package OnlyForChill;

import java.util.Scanner;


public class SekToMin {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите время в секундах: ");
        long num = sc.nextLong();
        long min = num / 60 % 60;
        long sec = num % 60;
       System.out.printf("%02d:%02d", min, sec);

        // ---------------------
        //Напишите класс, который принимает с клавиатуры промежуток времени,
        //выраженный в секундах, и выводит на экран его же,
        //но выраженный в минутах и секундах.
    }
}
