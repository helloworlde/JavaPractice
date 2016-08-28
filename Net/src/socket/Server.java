package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alpha on 16-8-9.
 */
public class Server {
    public static void test() {
        try {
            ServerSocket socket = new ServerSocket(30000);
            while (true) {
                Socket s = socket.accept();
                PrintStream printStream = new PrintStream(s.getOutputStream());
                printStream.println("服务器消息");
                printStream.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
