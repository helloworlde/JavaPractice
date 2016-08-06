package readfromprocess;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by alpha on 16-8-4.
 */
public class WriteToProcess {
    public void test() throws IOException {
        Process process = Runtime.getRuntime().exec("java ReadStandard");
        try (PrintStream printStream = new PrintStream(process.getOutputStream())) {
            printStream.println("普通的disco普通的摇");
            printStream.println(new WriteToProcess());
        }
    }
}

class ReadStandard {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             PrintStream printStream = new PrintStream(new FileOutputStream("oot.txt"))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                printStream.println("键盘输入的内容：" + scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
