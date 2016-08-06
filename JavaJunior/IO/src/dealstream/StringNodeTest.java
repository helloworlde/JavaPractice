package dealstream;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by alpha on 16-8-4.
 * 以数组为物理节点的流
 * StringReader和StringWriter
 */
public class StringNodeTest {
    public void test() {
        String src = "字符流，字节流\n"
                + "字符流，字节流\n"
                + "字符流，字节流\n"
                + "字符流，字节流\n"
                + "字符流，字节流";
        char[] buffer = new char[32];
        int hasRead = 0;
        try (StringReader stringReader = new StringReader(src)) {
            while ((hasRead = stringReader.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (StringWriter stringWriter = new StringWriter()) {
            stringWriter.write("StringWriter\n");
            stringWriter.write("StringWriter\n");
            stringWriter.write("StringWriter\n");
            stringWriter.write("StringWriter\n");
            stringWriter.write("StringWriter\n");
            stringWriter.write("StringWriter\n");
            System.out.println("-------StringWriter内容---------");
            System.out.println(stringWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
