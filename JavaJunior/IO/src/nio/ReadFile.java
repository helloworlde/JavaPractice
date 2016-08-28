package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by alpha on 16-8-7.
 */
public class ReadFile {
    public void test() {
        try (FileInputStream fileInputStream = new FileInputStream("poem.txt");
             FileChannel fileChannel = fileInputStream.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                Charset charset = Charset.forName("UTF-8");
                CharsetDecoder charsetDecoder = charset.newDecoder();
                CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
                System.out.println(charBuffer);
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
