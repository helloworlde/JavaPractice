package serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by alpha on 16-8-5.
 * 多次序列化同一对象时，只有第一次序列化时才会把该对象转换成字节输出
 */
public class WriterTeacher {
    public void test() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("teacher.txt"))) {
            Person person = new Person("Alice", 23);
            Teacher teacher = new Teacher("Anthony", person);
            Teacher teacher1 = new Teacher("Ying", person);
            objectOutputStream.writeObject(teacher);
            objectOutputStream.writeObject(teacher1);
            objectOutputStream.writeObject(person);
            objectOutputStream.writeObject(teacher1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
