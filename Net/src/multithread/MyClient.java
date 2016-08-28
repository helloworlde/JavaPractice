package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by alpha on 16-8-9.
 */
public class MyClient {
    public void test() {
        try {
            Socket socket = new Socket("127.0.0.1", 30000);
            new  Thread(new ClientThread(socket)).start();
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            String line = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while ((line = bufferedReader.readLine()) != null) {
                printStream.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
