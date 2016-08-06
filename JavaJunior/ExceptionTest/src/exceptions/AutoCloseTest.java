package exceptions;

import java.io.*;

/**
 * Created by alpha on 16-8-1.
 * try 语句括号里声明、初始化资源
 * 资源指必须在程序结束时显式关闭的资源
 * try会在该语句结束时自动关闭这些资源
 */
public class AutoCloseTest {
    public void closeTest() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("MainMethod.java"));
             PrintStream printStream = new PrintStream(new FileOutputStream("a.txt"))
        ) {
            System.out.println(bufferedReader.readLine());
            printStream.println("This is java Test");
        }
    }
}
