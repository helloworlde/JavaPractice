package stream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by alpha on 16-8-3.
 * 字节输入流，从文件读取并输出
 */
public class FileInputStreamTest {
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("FileInputStreamTest.java");
        byte[] bytes = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fis.read(bytes)) > 0) {
            System.out.println(new String(bytes, 0, hasRead));
        }
        fis.close();
    }
}
