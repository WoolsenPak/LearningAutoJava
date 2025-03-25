package module3.lesson2.interfaces;

import module3.lesson2.let.Treadmill;
import module3.lesson2.let.Wall;

public interface Actions {
    void run(Treadmill treadmill);
    void jump(Wall wall);
}
