package nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by alpha on 16-8-8.
 * 使用Files工具类查找指定文件
 */
public class FileVisitorTest {
    public void test() throws IOException {
        Files.walkFileTree(Paths.get("/","home"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问："+file+"文件");
                if (file.endsWith("poem.txt")) {
                    System.out.println("---已经找到目标文件---");
                    System.out.println("文件目录："+file);
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问："+dir+"路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
