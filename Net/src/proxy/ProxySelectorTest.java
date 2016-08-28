package proxy;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 16-8-10.
 */
public class ProxySelectorTest {
    final String PROXY_ADDR = "122.24.42.11";
    final int PROXY_PORT = 3124;
    String urlStr = "http://www.helloworlde.top";
    public void  test() throws IOException {
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                List<Proxy> result = new ArrayList<Proxy>();
                result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT)));
                return result;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                System.out.println("无法连接到服务器");
            }
        });

        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
    }
}
