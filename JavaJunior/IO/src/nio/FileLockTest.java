package nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by alpha on 16-8-7.
 * 文件锁
 */
public class FileLockTest {
    public void test() {
        try (FileChannel fileChannel = new FileOutputStream("poem.txt").getChannel()){
            FileLock lock = fileChannel.tryLock();
            Thread.sleep(10000);
            lock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
