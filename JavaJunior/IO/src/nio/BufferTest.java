package nio;

import java.nio.CharBuffer;

/**
 * Created by alpha on 16-8-7.
 * Buffer的常用方法
 */
public class BufferTest {
    public void test() {
        CharBuffer charBuffer = CharBuffer.allocate(8);
        System.out.println("capacity:" + charBuffer.capacity());
        System.out.println("limit:" + charBuffer.limit());
        System.out.println("position:" + charBuffer.position());
        System.out.println("------------------");

        charBuffer.put('a');
        charBuffer.put('b');
        charBuffer.put('c');

        System.out.println("加入元素后position：" + charBuffer.position());
        System.out.println("------------------");

        charBuffer.flip();
        System.out.println("filp后的limit:" + charBuffer.limit());
        System.out.println("position:" + charBuffer.position());
        System.out.println("第一个元素：" + charBuffer.get());
        System.out.println("取出元素后的position：" + charBuffer.position());

        System.out.println("------------------");
        charBuffer.clear();
        System.out.println("clear后的position：" + charBuffer.position());
        System.out.println("clear后的limit：" + charBuffer.limit());
        System.out.println("执行clear后缓冲器并没有被清空，第三个元素：" + charBuffer.get(2));
        System.out.println("执行绝对读取后position：" + charBuffer.position());

    }
}
