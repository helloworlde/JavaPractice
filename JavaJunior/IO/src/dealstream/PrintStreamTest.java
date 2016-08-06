package dealstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alpha on 16-8-4.
 * 处理流
 */
public class PrintStreamTest {
    public void test() {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("poem.txt");
                PrintStream printStream = new PrintStream(fileOutputStream)
        ) {
            printStream.println("普通字符串输出");
            printStream.println("hhhhhhhhh");
            printStream.println(new PrintStreamTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
