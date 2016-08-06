package serialize;

import java.io.*;

/**
 * Created by alpha on 16-8-5.
 * 序列化输出之后改变对象属性再次调用writeObject()方法不会再次输出
 */
public class SerializeMutable {
    public void test() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("mutable.txt"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("mutable.txt"))) {
            Person person = new Person("Alice", 23);
            objectOutputStream.writeObject(person);
            person.setName("Ying");
            objectOutputStream.writeObject(person);
            Person Alice = (Person) objectInputStream.readObject();
            Person Ying = (Person) objectInputStream.readObject();
            System.out.println("Alice == Ying?" + (Alice == Ying));
            System.out.println(Ying.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
