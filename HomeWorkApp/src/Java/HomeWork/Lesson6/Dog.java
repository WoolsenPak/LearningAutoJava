package HomeWork.Lesson6;

public class Dog extends Pets {
    private int maxRunDistance;
    private int maxSwimDistance;
    public static int dogCount = 0;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        dogCount++;
    }

    public Dog(String name) {
        this(name, 500, 10);
    }

    @Override
    public String run (int distance) {
        if (distance <= maxRunDistance) {
            return getName() + " пробежал " + distance + " м.";
        }
        else {
            return getName() + " не сможет пробежать :( " + distance + " м.";
        }
    }

    @Override
    public String swim (int distance) {
        if (distance <= maxSwimDistance) {
            return getName() + " проплыл " + distance + " м.";
        }
        else {
            return getName() + " не сможет проплыть :( " + distance + " м.";
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
