package module3.lesson3;

//        1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//        Например
//        "4" "3" "2" "2"
//        "1" "3" "2" "4"
//        "4" "3" "2" "2"
//        "1" "3" "2" "4"
//        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось
//        (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
//        исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//        3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.


public class main {
    static int sum = 0;

    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {
        String[][] array = {{"1","1","1","1"},
                            {"1","1","1","1"},
                            {"1","1","1","1"},
                            {"1","1","1","1"}};

        arrays(array);
        printTwoArrays(array);
    }

    public static void arrays(String[][] array) throws MyArraySizeException, MyArrayDataException {

        for (int i = 0; i < array.length; i++) {
            if (array.length > 4) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length > 4) {
                    throw new MyArraySizeException();
                }
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
        System.out.println("Sum > " + sum);
    }


    public static void printTwoArrays(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}


