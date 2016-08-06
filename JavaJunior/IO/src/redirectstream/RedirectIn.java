package redirectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alpha on 16-8-4.
 * 输入重定向
 * 将输入重定向为输入流
 */
public class RedirectIn {
    public void test() {
        try (FileInputStream fileInputStream = new FileInputStream("poem.txt")) {
            System.setIn(fileInputStream);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");//只把回车作为换行符
            while (scanner.hasNext()) {
                System.out.println("键盘输入内容：" + scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
