package serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by alpha on 16-8-5.
 * 读取序列化后写入文件中的对象
 * 反序列化
 */
public class ReadObject {
    public void test() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"))) {
            Person p = (Person) objectInputStream.readObject();
            Person p1 = (Person) objectInputStream.readObject();
            System.out.println(p.getName() + " " + p.getAge());
            System.out.println(p1.getName() + " " + p1.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
