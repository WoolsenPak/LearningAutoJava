package HomeWork.Lesson5;

public class HomeWork5 {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(
                "Самойлов Андрей Игоревич",
                "Дирижер",
                "pochta@mail.ru",
                "+79990000231",
                100000,
                35);
        employees[1] = new Employee(
                "Сергеей Даниил Аркадьевич",
                "Пианист",
                "mail@gmail.com",
                "+79990000231",
                70000,
                41);
        employees[2] = new Employee(
                "Иванов Степан Ильдарович",
                "Гитарист",
                "stepan@mail.ru",
                "+79999991211",
                35000,
                56);
        employees[3] = new Employee(
                "Кандибобер Ибрагим Григорьевич",
                "Барабанщик",
                "something@gmail.com",
                "+79991112222",
                80000,
                43);
        employees[4] = new Employee(
                "Филипп Киркоров Бедросович",
                "Директор",
                "fila@mail.ru",
                "+79997771231",
                200000,
                57);

        System.out.println("Вывод сотрудников старше 40 лет: \n");

        for (Employee employee : employees) {
            if (employee.getOnlyAge() > 40) {
                System.out.println(employee.getInformantion());
            }
        }
    }
}
