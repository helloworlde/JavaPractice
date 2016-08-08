package nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Date;
import java.util.List;

/**
 * Created by alpha on 16-8-8.
 * 访问文件属性
 */
public class AttributeVIewTest {
    public void test() {
        Path testPath = Paths.get("poem.txt");
        try {
            BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
            BasicFileAttributes basicFileAttributes = basicFileAttributeView.readAttributes();
            System.out.println("创建时间：" + new Date(basicFileAttributes.creationTime().toMillis()));
            System.out.println("最后访问时间：" + new Date(basicFileAttributes.lastAccessTime().toMillis()));
            System.out.println("最后修改时间：" + new Date(basicFileAttributes.lastModifiedTime().toMillis()));
            System.out.println("文件大小：" + basicFileAttributes.size());

            FileOwnerAttributeView ownerAttributeView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
            System.out.println("所属用户：" + ownerAttributeView.getOwner());
            UserPrincipal user = FileSystems.getDefault()
                    .getUserPrincipalLookupService()
                    .lookupPrincipalByName("guest");
            ownerAttributeView.setOwner(user);

            UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
            List<String> attrNames = userDefinedFileAttributeView.list();
            for (String name : attrNames) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(userDefinedFileAttributeView.size(name));
                userDefinedFileAttributeView.read(name, byteBuffer);
                byteBuffer.flip();
                String value = Charset.defaultCharset().decode(byteBuffer).toString();
                System.out.println(name + "-->" + value);
            }
            userDefinedFileAttributeView.write("发行者", Charset.defaultCharset().encode("HelloWood"));

            DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);
            dosFileAttributeView.setHidden(true);
            dosFileAttributeView.setReadOnly(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
