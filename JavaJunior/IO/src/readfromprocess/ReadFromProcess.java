package readfromprocess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alpha on 16-8-4.
 */
public class ReadFromProcess {
    public void test() throws IOException {
        Process process = Runtime.getRuntime().exec("java");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String buff = null;
            while ((buff = bufferedReader.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }
}
