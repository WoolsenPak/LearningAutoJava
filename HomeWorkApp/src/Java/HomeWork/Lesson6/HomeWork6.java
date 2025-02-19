package HomeWork.Lesson6;

public class HomeWork6 {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобёр");
        Dog dog2 = new Dog("Штрих");
        Cat cat1 = new Cat("Симба");
        Cat cat2 = new Cat("Аист");

        dog1.run(150);
        dog2.run(600);
        dog1.swim(5);
        dog2.swim(15);

        cat1.run(100);
        cat1.run(250);
        cat2.swim(10);

        System.out.println("Всего животных: " + Pets.getPetsCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

    }
}
