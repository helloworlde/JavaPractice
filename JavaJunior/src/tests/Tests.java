package tests;

/**
 * Created by alpha on 16-7-15.
 */
public class Tests implements B {
    @Override
    public void printB() {
        System.out.println(SA);
    }

    public void printA() {
        System.out.println("A");
    }
}
