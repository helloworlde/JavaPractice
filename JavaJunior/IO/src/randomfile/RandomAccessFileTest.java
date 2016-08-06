package randomfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by alpha on 16-8-5.
 * 任意位置读取文件
 * 指定位置读取文件内容
 */
public class RandomAccessFileTest {
    public void test() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("poem.txt", "r")) {
            System.out.println("指针初始位置：" + randomAccessFile.getFilePointer());
            randomAccessFile.seek(300);
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while ((hasRead = randomAccessFile.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
