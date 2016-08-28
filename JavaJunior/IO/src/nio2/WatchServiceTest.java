package nio2;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by alpha on 16-8-8.
 * 监控文件的状态
 */
public class WatchServiceTest {
    public void test() {
        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Paths.get("/home/alpha/IdeaProjects/out/production/IdeaProjects/").register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(event.context() + "发生了" + event.kind() + "事件");
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
