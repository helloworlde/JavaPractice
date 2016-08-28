package junior;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by alpha on 16-8-9.
 * URL编码和解码
 */
public class URLDecoderTest {
    public static void test() {
        try {
            String keyWord = URLDecoder.decode("%C4%E3%BA%C3%A3%AC%B9%FE%B9%FE%B9%FEJava", "GBK");
            System.out.println(keyWord);
            String urlStr = URLEncoder.encode("你好，哈哈哈Java", "GBK");
            System.out.println(urlStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
