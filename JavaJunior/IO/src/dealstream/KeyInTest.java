package dealstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alpha on 16-8-4.
 * 将字节输入流转换成字符输入流
 * 将InputStreamReader包装BufferReader
 */
public class KeyInTest {
    public void test() {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                System.out.println("输入内容：" + line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
