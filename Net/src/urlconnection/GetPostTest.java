package urlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by alpha on 16-8-9.
 * Get和Post方式与web交换数据
 */
public class GetPostTest {

    /**
     * 发送get请求
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            URLConnection connection = realUrl.openConnection();
            connection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("发送get请求异常" + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送post请求
     */
    public static String sendPost(String url, String param) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {
                out.print(param);
                out.flush();
            }
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void test() {
        String s = GetPostTest.sendGet("http://localhost:8080/abc/a.jsp", null);
        System.out.println(s);

        String s1 = GetPostTest.sendPost("http://localhost:8080/abc/login.jsp", "name=zhang&pass=zhang");
        System.out.println(s1);
    }
}
