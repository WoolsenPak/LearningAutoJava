package HomeWork.Lesson7_2;

public class DataBase {
    private final Directory info1 = new Directory();
    private final Directory info2 = new Directory();

    public Directory getInfo1() {
        info1.setAddress("Moscow");
        info1.setPhone("+79991672311");
        info1.setLogin("login");
        info1.setPassword("password");
        return info1;
    }

    public Directory getInfo2() {
        info2.setAddress("Pskov");
        info2.setPhone("+7990000311");
        info2.setLogin("lkll");
        info2.setPassword("#@!sdds");
        return info2;
    }

    public Directory[] listDirectory = {getInfo1(), getInfo2()};

}
