package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by alpha on 16-8-10.
 * 使用UDP连接
 */
public class UdpClient {
    public static final int DEST_PORT = 30000;
    public static final String DEST_IP = "127.0.0.1";
    private static final int DATA_LEN = 4096;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPacket = null;

    public void test() {
        try (DatagramSocket socket = new DatagramSocket()) {
            outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), DEST_PORT);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                byte[] buff = scanner.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
                socket.receive(inPacket);
                System.out.println(new String(inBuff,0,inPacket.getLength()));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
