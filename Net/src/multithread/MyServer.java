package multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alpha on 16-8-9.
 */
public class MyServer {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void test() {
        try {
            ServerSocket socket = new ServerSocket(30000);
            while (true) {
                Socket s= socket.accept();
                socketList.add(s);
                new Thread(new ServerThread(s)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
