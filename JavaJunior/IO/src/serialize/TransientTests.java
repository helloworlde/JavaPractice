package serialize;

import java.io.*;

/**
 * Created by alpha on 16-8-7.
 * 使用transient修饰的对象和属性在序列化时不会被序列化
 */
public class TransientTests {
    public void test() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("transient.txt"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("transient.txt"))) {
            Person person = new Person("Alice", 22);
            objectOutputStream.writeObject(person);
            Person person1 = (Person) objectInputStream.readObject();
            System.out.println(person1.getAge());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
