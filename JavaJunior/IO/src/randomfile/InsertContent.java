package randomfile;

import java.io.*;

/**
 * Created by alpha on 16-8-5.
 * 使用RandomAccessFile向文件中插入内容
 * 先读取指定位置之后的内容到临时文件中，然后插入内容，从临时文件中读取并写入之前的文件内容
 */
public class InsertContent {
    public void test() throws IOException {
        File file = File.createTempFile("tmp", null);
        file.deleteOnExit();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("poem.txt", "rw");
             FileOutputStream tmpOut = new FileOutputStream(file);
             FileInputStream tmpIn = new FileInputStream(file)) {
            randomAccessFile.seek(300);
            //将文件内容写入临时文件中
            byte[] buffer = new byte[64];
            int hasRead = 0;
            while ((hasRead = randomAccessFile.read(buffer)) > 0) {
                tmpOut.write(buffer, 0, hasRead);
            }
            randomAccessFile.seek(300);
            randomAccessFile.write("插入的内容".getBytes());
            //追加之前的内容
            while ((hasRead = tmpIn.read(buffer)) > 0) {
                randomAccessFile.write(buffer, 0, hasRead);
            }

        }
    }
}
