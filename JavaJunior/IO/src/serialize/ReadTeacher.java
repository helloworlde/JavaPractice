package serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by alpha on 16-8-5.
 */
public class ReadTeacher {
    public void test() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("teacher.txt"))) {
            Teacher teacher = (Teacher) objectInputStream.readObject();
            Teacher teacher1 = (Teacher) objectInputStream.readObject();
            Person person = (Person) objectInputStream.readObject();
            Teacher teacher2 = (Teacher) objectInputStream.readObject();
            System.out.println("teacher.student == person?" + (teacher.getStudent() == person));
            System.out.println("teacher1.student == person?" + (teacher.getStudent() == person));
            System.out.println("teacher1 == teacher2?" + (teacher1 == teacher2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
