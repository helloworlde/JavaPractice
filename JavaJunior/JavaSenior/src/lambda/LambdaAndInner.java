package lambda;

/**
 * Created by alpha on 16-7-21.
 */
public class LambdaAndInner {
    private static String name = "HelloWood";
    private int age = 12;

    public void test() {
        String book = "哈哈哈哈";
        Displayable displayable = () -> {
            System.out.println("book局部变量" + book);
            System.out.println("外部类age实例变量" + age);
            System.out.println("外部类name类变量" + name);
        };
        displayable.display();
        System.out.println(displayable.add(3, 4));
    }
}
