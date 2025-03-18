package module3.lesson2.general;

import module3.lesson2.interfaces.Actions;
import module3.lesson2.actors.Cat;
import module3.lesson2.actors.Human;
import module3.lesson2.actors.Robot;
import module3.lesson2.let.Treadmill;
import module3.lesson2.let.Wall;
//1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
// Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
// 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,участники должны выполнять соответствующие действия (бежать или прыгать),
// результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина (для дорожки) или высота (для стены),
// а участников ограничения на бег и прыжки.
//3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
// Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.


public class main {

    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill(20, 2);
        Wall wall = new Wall (100, 2);
        Actions[] objs = {new Cat(100), new Human(150), new Robot(200)};
        for (int i = 0; i < objs.length; i++){
            objs[i].run(treadmill);
            objs[i].jump(wall);
        }

    }
}
