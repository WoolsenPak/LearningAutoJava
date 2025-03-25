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
    static int maxSize = 4;

    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {
        String[][] array =
                {{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}};

        try {
            System.out.println("Sum of numbers > " + sumArray(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        printTwoArrays(array);
    }


    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        sizeArray(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)

                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Array can work only with numbers, error: [" + i + "]" + "[" + j + "]");
                }
        }
        return sum;
    }


    public static void sizeArray(String[][] array) throws MyArraySizeException {

        for (int i = 0; i < array.length; i++) {
            if (array.length > maxSize) {
                throw new MyArraySizeException("Array length must be " + maxSize + " but is " + array.length);
            }
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length > maxSize) {
                    throw new MyArraySizeException("Array length must be " + maxSize + " but is " + array[i].length);
                }
            }
        }
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


