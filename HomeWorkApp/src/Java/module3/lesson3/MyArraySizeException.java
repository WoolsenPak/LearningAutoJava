package module3.lesson3;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super();
        System.out.println("Array length must be 4");
    }
}
