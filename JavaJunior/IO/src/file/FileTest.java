package file;

import java.io.File;
import java.io.IOException;

/**
 * Created by alpha on 16-8-3.
 * File类
 */
public class FileTest {
    public void test() throws IOException {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        File tmpFile = File.createTempFile("临时文件", ".txt", file);
        tmpFile.deleteOnExit();
        File newFile = new File(System.currentTimeMillis() + "时间命名文件");
        System.out.println("newFile是否存在:" + newFile.exists());
        newFile.createNewFile();
        newFile.mkdir();
        String[] fileList = file.list();
        System.out.println("-------当前路径下的所有文件和路径--------");
        for (String fileName :
                fileList) {
            System.out.println(fileName);
        }
        File[] roots = File.listRoots();
        System.out.println("------系统所有根路径如下-------");
        for (File root :
                roots) {
            System.out.println(root);
        }

    }
}
