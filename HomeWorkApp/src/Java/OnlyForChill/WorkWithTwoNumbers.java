package OnlyForChill;

import java.util.Scanner;

public class WorkWithTwoNumbers {
   static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
       workWithTwoNumbers();
   }
   public static void workWithTwoNumbers() {

       System.out.print("Введите первое число: ");
       int a = input.nextInt();
       System.out.print("Введите второе число: ");
       int b = input.nextInt();
       int sum = a + b;
       int minus = a - b;
       int mul = a * b;
       System.out.print("Сумма: " + sum + "\n");
       System.out.print("Разность: " + minus + "\n");
       System.out.print("Произведение: " + mul + "\n");
       if (b != 0) {
           double div =  (double) a / b;
           System.out.print("Частное: " + div + "\n");
       } else System.out.print ("Ошибка: деление на ноль!" + "\n");



   }
}
