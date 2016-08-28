package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by alpha on 16-8-7.
 */
public class RandomFileChannelTest {
    public void test() {
        File file = new File("poem.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
             FileChannel fileChannel = randomAccessFile.getChannel()) {
            ByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            fileChannel.position(file.length());
            fileChannel.write(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
