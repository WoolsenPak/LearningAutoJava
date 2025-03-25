package module3.lesson2.actors;

import module3.lesson2.interfaces.Actions;
import module3.lesson2.let.Treadmill;
import module3.lesson2.let.Wall;

public class Cat implements Actions {
    public int stamina;

    public Cat(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public void run(Treadmill treadmill) {
        for (int i = 0; i < treadmill.count; i++) {
            if (treadmill.length > stamina) {
                System.out.println("Кот не смог пробежать " + (i + 1) + " раз :(");
                break;
            } else System.out.println("Кот пробежал " + (i + 1) + " раз.");
            stamina = stamina - treadmill.length;
        }
    }

    @Override
    public void jump(Wall wall) {
        for (int i = 0; i < wall.count; i++) {
            if (wall.height > stamina) {
                System.out.println("Кот не смог перепрыгнуть " + (i + 1) + " раз :(");
                break;
            } else System.out.println("Кот перепрыгнули " + (i+1) + " раз.");
            stamina = stamina - wall.height;
        }
    }
}
