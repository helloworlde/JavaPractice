package lambda;

/**
 * Created by alpha on 16-7-21.
 */
public class LambdaQs {
    public void eat(Eatable eatable) {
        System.out.println(eatable);
        eatable.taste();
    }

    public void drive(Flyable flyable) {
        System.out.println("正在驾驶" + flyable);
        flyable.fly("晴天");
    }

    public void test(Addable addable) {
        System.out.println("5+3=" + addable.add(3, 5));
    }


}
