package talk;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alpha on 16-8-9.
 */
public class Server {
    private static final int SERVER_PORT = 30000;
    public static DefinedMap<String,PrintStream> clents = new DefinedMap<>();

    public void init() {
        try {
            ServerSocket socket = new ServerSocket(SERVER_PORT);
            while (true) {
                Socket s = socket.accept();
//                new ServerThread(s).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test() {
        Server server = new Server();
        server.init();
    }
}
