package HomeWork.Lesson7_2;

import java.util.Scanner;

public class Starter {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = new String[4];
        Directory directory = new Directory();

        Directory[] read =  directory.read();

        System.out.println("address: " + read[0].getAddress()
                + "\n"+ "phone: " + read[0].getPhone()
                + "\n"+ "login: " + read[0].getLogin()
                + "\n"+ "password: " + read[0].getPassword());

        System.out.println("==============================");

        System.out.println("address: " + read[1].getAddress()
                + "\n"+ "phone: " + read[1].getPhone()
                + "\n"+ "login: " + read[1].getLogin()
                + "\n"+ "password: " + read[1].getPassword());

        System.out.println("Enter the address of the directory: ");
        array[0] = sc.nextLine();

        System.out.println("Enter the phone of the directory: ");
        array[1] = sc.nextLine();

        System.out.println("Enter the login of the directory: ");
        array[2] = sc.nextLine();

        System.out.println("Enter the password of the directory: ");
        array[3] = sc.nextLine();

        directory.write(array);
    }
}
