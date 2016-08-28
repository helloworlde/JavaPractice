package nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by alpha on 16-8-8.
 * Path接口的功能和用法
 */
public class PathTest {
    public void test() {
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量："+path.getNameCount());
        System.out.println("path的根路径："+path.getRoot());

        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println("absolutePath的根路径："+absolutePath.getRoot());
        System.out.println("absolutePath包含的路径数量："+absolutePath.getNameCount());
        System.out.println(absolutePath.getName(3));

        Path path1 = Paths.get("/","home","alpha");
        System.out.println(path1);
    }
}
