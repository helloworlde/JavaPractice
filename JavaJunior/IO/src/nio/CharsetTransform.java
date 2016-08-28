package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by alpha on 16-8-7.
 */
public class CharsetTransform {
    public void test() throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");
        CharsetEncoder encoder = charset.newEncoder();
        CharsetDecoder decoder = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.put('L');
        charBuffer.put('C');
        charBuffer.put('C');
//        charBuffer.put('L');
//        charBuffer.put('L');
//        charBuffer.put('C');
//        charBuffer.put('C');
//        charBuffer.put('C');
        charBuffer.flip();

        ByteBuffer byteBuffer = encoder.encode(charBuffer);
        for (int i = 0; i < byteBuffer.capacity()/2; i++) {
            System.out.print(byteBuffer.get(i)+" ");
        }
//        System.out.print(byteBuffer.get(0)+" ");
//        System.out.print(byteBuffer.get(1)+" ");
//        System.out.print(byteBuffer.get(2)+" ");
//        System.out.print(byteBuffer.get(3)+" ");
//        System.out.print(byteBuffer.get(4)+" ");
//        System.out.print(byteBuffer.get(5)+" ");
//        System.out.print(byteBuffer.get(6)+" ");
//        System.out.println(byteBuffer.get(7)+" ");
//        System.out.println(byteBuffer.capacity());
        System.out.println("\n"+decoder.decode(byteBuffer));
    }
}
