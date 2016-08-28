package urlconnection;

import java.io.IOException;

/**
 * Created by alpha on 16-8-9.
 */
public class MultiThreadDown {
    public static void test() {
        final DownUtil downUtil = new DownUtil("http://www.helloworlds.top/JDStruts/a.jpg","iso.jpg",4);
        try {
            downUtil.download();
            new Thread(()-> {
                while (downUtil.getCompleteRate() < 1) {
                    System.out.println("已完成："+downUtil.getCompleteRate());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
