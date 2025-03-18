package module3.lesson2.actors;

import module3.lesson2.interfaces.Actions;
import module3.lesson2.let.Treadmill;
import module3.lesson2.let.Wall;

public class Human implements Actions {
    public int stamina;

    public Human(int stamina) {
       this.stamina = stamina;
    }

    @Override
    public void run(Treadmill treadmill) {
        for (int i = 0; i < treadmill.count; i++) {
        if (stamina > treadmill.length) {
            System.out.println("Человек не смог пробежать " + (i + 1) + " раз :(");
            break;
        } else {
            stamina = stamina - treadmill.length;
            System.out.println("Человек пробежал " + (i + 1) + " раз.");
        }
        }
    }

    @Override
    public void jump(Wall wall) {
        for (int i = 0; i < wall.count; i++) {
            if (wall.height > stamina) {
                System.out.println("Человек не смог перепрыгнуть " + (i + 1) + " раз :(");
                break;
            } else System.out.println("Человек перепрыгнул " + (i + 1) + " раз.");
            stamina--;
        }
    }
}

