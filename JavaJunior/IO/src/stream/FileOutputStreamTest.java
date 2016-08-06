package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alpha on 16-8-3.
 * 字节流输出
 * 从文件中读取并输出到其他文件中
 */
public class FileOutputStreamTest {
    public void test() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
             FileInputStream fileInputStream = new FileInputStream("FileInputStreamTest.java")) {
            byte[] bytes = new byte[1024];
            int hasRead = 0;
            while ((hasRead = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
