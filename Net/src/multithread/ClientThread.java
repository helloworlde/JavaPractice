package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by alpha on 16-8-9.
 */
public class ClientThread implements Runnable {

    private Socket socket;
    BufferedReader bufferedReader = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run() {
        try {
            String content = null;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
