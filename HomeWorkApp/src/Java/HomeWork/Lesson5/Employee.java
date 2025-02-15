package HomeWork.Lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getInformantion() {
        return "MyFullName: " + fullName + "\n" +
                "MyPosition: " + position + "\n" +
                "MyEmail: " + email + "\n" +
                "MyPhoneNumber: " + phoneNumber + "\n" +
                "MySalary: " + salary + "\n" +
                "MyAge: " + age + "\n";
    }

    public int getOnlyAge() {
        return age;
    }
}

