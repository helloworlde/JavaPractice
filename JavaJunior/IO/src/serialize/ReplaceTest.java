package serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by alpha on 16-8-7.
 * 将对象替换为其他对象后序列化
 */
public class ReplaceTest {
    public void test() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("replace.txt"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("replace.txt"))) {
            Person person = new Person("Alice", 23);
            objectOutputStream.writeObject(person);
            ArrayList list = (ArrayList) objectInputStream.readObject();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
