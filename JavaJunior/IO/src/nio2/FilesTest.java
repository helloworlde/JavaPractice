package nio2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 16-8-8.
 * Paths和Files工具类的使用
 */
public class FilesTest {
    public void test() {
        try {
            Files.copy(Paths.get("poem.txt"), new FileOutputStream("c.txt"));
            System.out.println("是否为隐藏文件："+Files.isHidden(Paths.get("poem.txt")));

            List<String> lines = Files.readAllLines(Paths.get("poem.txt"));
            System.out.println("----------------------");
            System.out.println(lines);
            System.out.println("----------------------");
            System.out.println("poem.txt的大小："+Files.size(Paths.get("poem.txt")));
            System.out.println("----------------------");
            List<String> poem = new ArrayList<>();
            poem.add("Hello");
            poem.add("Wood");

            Files.write(Paths.get("poem.txt"), poem);
            Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
            System.out.println("----------------------");
            Files.lines(Paths.get("poem.txt")).forEach(line -> System.out.println(line));
            System.out.println("----------------------");
            FileStore store = Files.getFileStore(Paths.get("/home"));

            System.out.println("共有空间："+store.getTotalSpace());
            System.out.println("可用空间："+store.getUsableSpace());
            System.out.println("已用空间："+store.getUnallocatedSpace());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
