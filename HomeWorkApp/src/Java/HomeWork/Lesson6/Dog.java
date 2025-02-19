package HomeWork.Lesson6;

public class Dog extends Pets {
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run (int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        }
        else {
            System.out.println(getName() + " не сможет пробежать :( " + distance + " м.");
        }
    }

    public void swim (int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        }
        else {
            System.out.println(getName() + " не сможет проплыть :( " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
