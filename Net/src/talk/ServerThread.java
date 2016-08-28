package talk;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by alpha on 16-8-10.
 */
public class ServerThread extends Thread {
    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

   /* @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(DefinedProtocol.USER_ROUND)&&line.endsWith(DefinedProtocol.USER_ROUND)) {
                    String username = getRealMsg(line);
                    if (Server.clents.map.containsKey(username)) {
                        System.out.println("重复");
                        ps.println(DefinedProtocol.NAME_REP);
                    }
                    else {
                        System.out.println("成功");
                        ps.println(DefinedProtocol.LOGIN_SUCCESS);
                        Server.clents.put(username, ps);
                    }
                } else if (line.startsWith(DefinedProtocol.PRIVATE_ROUND) && line.endsWith(DefinedProtocol.PRIVATE_ROUND)) {
                    String userAndMsg = getRealMsg(line);
                    String user = userAndMsg.substring(DefinedProtocol.SPLIT_SIGN)[0];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
