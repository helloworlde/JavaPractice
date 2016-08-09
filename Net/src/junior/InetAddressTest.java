package junior;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by alpha on 16-8-9.
 */
public class InetAddressTest {
    public void test() {
        try {
            InetAddress address = InetAddress.getByName("www.helloworlde.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
