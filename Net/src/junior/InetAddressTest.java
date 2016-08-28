package junior;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by alpha on 16-8-9.
 * InetAddress使用
 */
public class InetAddressTest {
    public static void test() {
        try {
            InetAddress address = InetAddress.getByName("www.helloworlds.top");
            System.out.println("是否可达："+address.isReachable(2000));
            System.out.println(address.getHostAddress());

            InetAddress local = InetAddress.getLocalHost();
            System.out.println("本机是否可达："+local.isReachable(1000));
            System.out.println(local.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
