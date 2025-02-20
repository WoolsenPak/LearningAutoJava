package HomeWork.Lesson6;

public class Cat extends Pets {
    private int maxRunDistance;
    private static int catCount = 0;

    public Cat(String name, int maxRunDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;;
        catCount++;
    }

    public Cat (String name) {
        this(name, 200);
    }

    @Override
    public String run(int distance) {
        if (distance <= maxRunDistance) {
            return getName() + " пробежал " + distance + " м.";
        } else {
            return getName() + " не сможет пробежать :( " + distance + " м.";
        }
    }

    @Override
    public String swim(int distance) {
        return getName() + " не умеет плавать.";
    }


    public static int getCatCount() {
        return catCount;
    }
}
