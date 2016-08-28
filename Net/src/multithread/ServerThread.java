package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by alpha on 16-8-9.
 */
public class ServerThread implements Runnable {

    Socket s = null;
    BufferedReader br = null;
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content = null;
            while ((content = readFromClient()) != null) {
                for (Socket s :
                        MyServer.socketList) {
                    PrintStream printStream = new PrintStream(s.getOutputStream());
                    printStream.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.socketList.remove(s);
            e.printStackTrace();
        }
        return null;
    }
}
