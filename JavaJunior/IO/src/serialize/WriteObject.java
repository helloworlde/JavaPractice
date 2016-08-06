package serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by alpha on 16-8-5.
 * 将序列化对象写入到文件中
 */
public class WriteObject {
    public void test() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            Person person = new Person("HelloWood", 22);
            Person person1 = new Person("HoloWood", 33);
            objectOutputStream.writeObject(person);
            objectOutputStream.writeObject(person1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
