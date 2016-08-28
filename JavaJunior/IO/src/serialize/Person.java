package serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by alpha on 16-8-5.
 */
public class Person implements Serializable {
    private String name;
    private transient int age;

    public Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    * 自定义序列化
    *
    * */

    //写入自定义的序列化对象
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(new StringBuffer(name).reverse());
        objectOutputStream.writeInt(age);
    }
    //读取自定义的序列化对象
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer) objectInputStream.readObject()).reverse().toString();
        this.age = objectInputStream.readInt();
    }

    //将对象替换为其他类型的对象
    //重写父类的方法
    private Object writeReplace() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }
}
