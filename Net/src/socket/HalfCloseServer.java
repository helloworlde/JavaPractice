package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by alpha on 16-8-10.
 * 半关闭的Input/Output
 */
public class HalfCloseServer {


    public void test() throws IOException {
        ServerSocket serverSocket = new ServerSocket(30000);
        Socket socket = serverSocket.accept();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("服务器第一条数据");
        ps.println("服务器第二条数据");
        socket.shutdownOutput();
        System.out.println(socket.isClosed());
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
        socket.close();
        serverSocket.close();
    }
}
