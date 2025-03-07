package OnlyForChill;

import java.util.Scanner;

public class myNameIs {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите ваше имя: ");
        String name = sc.nextLine();
        System.out.println ("Привет, " + name + "! Добро пожаловать в мир программирования на Java!");
    }

}
