package dealstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by alpha on 16-8-4.
 * 推回输入流
 */
public class PushbackTest {
    public void test() {
        try (PushbackReader pushbackReader = new PushbackReader(new FileReader("poem.txt"), 64)) {

            char[] buf = new char[32];
            String lastContent = "";
            int hasRead = 0;
            while ((hasRead = pushbackReader.read(buf)) > 0) {
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                if ((targetIndex = (lastContent + content).indexOf("Stream")) > 0) {
                    pushbackReader.unread((lastContent + content).toCharArray());
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    pushbackReader.read(buf, 0, targetIndex);
                    System.out.println(new String(buf, 0, targetIndex));
                    System.exit(0);
                } else {
                    System.out.println(lastContent);
                    lastContent = content;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
