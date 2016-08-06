package redirectstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by alpha on 16-8-4.
 * 重定向输出，将输出定向到输出流中
 */
public class RedirectOut {
    public void test() {
        try (PrintStream printStream = new PrintStream(new FileOutputStream("out.txt"))) {
            System.setOut(printStream);
            System.out.println("普通字符串");
            System.out.println(new RedirectOut());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
