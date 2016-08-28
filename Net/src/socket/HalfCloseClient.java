package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by alpha on 16-8-10.
 * 半关闭的Input/Output
 */
public class HalfCloseClient {
    public void test() throws IOException {
        Socket socket = new Socket("127.0.0.1", 30000);
        InputStream inputStream = socket.getInputStream();
        System.out.println(inputStream.read());
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("hhhhhhhhh");
        printStream.println("hhhhhhhhh");
        printStream.println("hhhhhhhhh");
        printStream.println("hhhhhhhhh");
        printStream.println("hhhhhhhhh");
        printStream.println("hhhhhhhhh");
        socket.shutdownInput();
        System.out.println(socket.isInputShutdown());
        printStream.close();
        inputStream.close();
        socket.close();
    }
}
