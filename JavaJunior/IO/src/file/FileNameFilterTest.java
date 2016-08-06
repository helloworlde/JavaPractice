package file;

import java.io.File;

/**
 * Created by alpha on 16-8-3.
 * 文件过滤器
 * 过滤输出所有.java文件和目录
 */
public class FileNameFilterTest {
    public void test() {
        File file = new File(".");
        String[] nameList = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for (String name :
                nameList) {
            System.out.println(name);
        }
    }
}
