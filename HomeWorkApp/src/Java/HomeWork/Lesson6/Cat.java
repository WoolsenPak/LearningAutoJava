package HomeWork.Lesson6;

public class Cat extends Pets {
    private final int MAX_RUN_DISTANCE = 200;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не cможет пробежать :( " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать :(");
    }


    public static int getCatCount() {
        return catCount;
    }
}
