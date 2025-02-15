package HomeWork.Lesson2;

public class SecondHomeWork {
    public static void main(String[] args) {
        System.out.println(firstTask(20, 10));
        secondTask(-10);
        System.out.println(thirdTask(-10));
        fourTask("Привет", 3);
        System.out.println(theFifthTask(400));
    }

    public static boolean firstTask(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    public static void secondTask(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean thirdTask(int a) {
        return a < 0;
    }

    public static void fourTask (String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    public static boolean theFifthTask(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || year % 400 == 0;

    }

}
