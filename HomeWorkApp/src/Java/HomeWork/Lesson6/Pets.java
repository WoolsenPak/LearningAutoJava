package HomeWork.Lesson6;

public abstract class Pets {
    protected String name;
    protected static int petsCount = 0;

    public Pets (String name) {
        this.name = name;
        petsCount++;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);

    public static int getPetsCount() {
        return petsCount;
    }
}


