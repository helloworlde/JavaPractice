package proxy;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

/**
 * Created by alpha on 16-8-10.
 * 使用代理访问网络
 */
public class ProxyTest {
    final String PROXY_ADDR = "129.82.12.188";
    final int PROXY_PORT = 3124;
    String urlStr = "http://www.helloworlde.top";

    public void test() {
        try {
            URL url = new URL(urlStr);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
            URLConnection connection = url.openConnection(proxy);
            connection.setConnectTimeout(3000);

            Scanner scanner = new Scanner(connection.getInputStream());
            PrintStream printStream = new PrintStream("index.html");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                printStream.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
