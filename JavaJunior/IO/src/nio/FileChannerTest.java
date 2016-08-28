package nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by alpha on 16-8-7.
 */
public class FileChannerTest {
    public void test() {
        File file = new File("poem.txt");
        try (FileChannel inFileChannel = new FileInputStream(file).getChannel();
             FileChannel outFileChannel = new FileOutputStream("channel.txt").getChannel()) {
            MappedByteBuffer byteBuffer = inFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            Charset charset = Charset.forName("UTF-8");
            outFileChannel.write(byteBuffer);
            byteBuffer.clear();
            CharsetDecoder charsetDecoder = charset.newDecoder();
            CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
            System.out.println(charBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
