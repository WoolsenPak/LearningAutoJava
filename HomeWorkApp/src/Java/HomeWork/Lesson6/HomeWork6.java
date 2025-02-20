package HomeWork.Lesson6;

public class HomeWork6 {

    public static void main(String[] args) {
        Dog dog = new Dog("Бобёр");
        Cat cat = new Cat("Симба");

        System.out.println(dog.run(450));
        System.out.println(dog.swim(100));
        System.out.println(cat.run(150));
        System.out.println(cat.swim(200));

        System.out.println("Всего животных: " + Pets.getPetsCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

    }
}
