package randomfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by alpha on 16-8-5.
 * 向指定文件末尾追加内容
 */
public class AppendContent {
    public void test() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("poem.txt", "rw")) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write("追加的内容！\n".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
