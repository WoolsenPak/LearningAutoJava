package OnlyForChill;

public class PositiveNumbers {

    public static void main(String[] args) {
        perechislenie (200);
     }

        public static void perechislenie(int num) {
            for (int i = num;  i > 0; i--) {
               if ((i + 3) % 10 == 0 && i < 99 && i > 10) {
                    System.out.println(i);
                }
            }
        }
    }
    // ------------------
    // Напишите класс, который выводит на экран положительные двузначные числа,
    // заканчивающиеся на цифру 7 (начиная с наибольшего).


