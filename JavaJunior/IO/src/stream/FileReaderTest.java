package stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by alpha on 16-8-3.
 * 字符输入流，从文件读取并输入
 */
public class FileReaderTest {
    public void test() {
        try (FileReader fileReader = new FileReader("FileInputStreamTest.java")) {
            char[] chars = new char[1024];
            int hasRead = 0;
            while ((hasRead = fileReader.read(chars)) > 0) {
                System.out.println(new String(chars, 0, hasRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
