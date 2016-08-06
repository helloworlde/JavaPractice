package unit5;

/**
 * Created by alpha on 16-7-18.
 */

class Creature {
    public Creature() {
        System.out.println("Creature无参数的构造器");
    }
}

class Animal extends Creature {
    public Animal(String name) {
        System.out.println("Animal带参数的构造器，该动物的name为：" + name);
    }

    public Animal(String name, int age) {
        this(name);
        System.out.println("Animal带两个参数的构造器，该动物的age为：" + age);
    }
}

public class Wolf extends Animal {
    public Wolf() {
        super("灰太狼", 3);
        System.out.println("Wolf无参数构造函数");
    }
}



