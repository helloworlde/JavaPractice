package exceptions;

/**
 * Created by alpha on 16-8-3.
 * finally外的语句在finally执行后也会被执行
 */
public class ThrowsException {

    public void test() {
        System.out.println("exception");
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("after finally");
    }
}
