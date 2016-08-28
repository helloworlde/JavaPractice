import reflectandgeneric.GenericTest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by alpha on 16-8-23.
 */
public class MainMethod {
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
//        BootstrapTest.test();
//        ClassLoaderPropTest.test();
//        System.out.println(URLClassLoaderTest.getConn("jdbc:mysql://localhost:3306/ubuntu","root","123456"));
//        ClassTest.test();
//        MethodParameterTest.test();
        /*ObjectPoolFactory factory = new ObjectPoolFactory();
        factory.initPool("obj.txt");
        System.out.println(factory.getObject("a"));
        System.out.println(factory.getObject("b"));*/

//        CreateJFrame.test();

       /* ExtendedObjectPoolFactory factory = new ExtendedObjectPoolFactory();
        factory.init("extObj.txt");
        factory.initPoll();
        factory.initProperty();
        System.out.println(factory.getObject("a"));*/


        //访问成员变量值
        /*Person p = new Person();
        Class<Person> personClass = Person.class;

        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p, "HelloWood");
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p, 30);
        System.out.println(p);*/

//        ArrayTest1.test();
//        ArrayTest2.test();
//        ProxyTest.test();
        /*Dog target =new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();*/

        /*Date d = (Date) ObjectFactoryTest.getInstance("java.util.Date");

        Date d1 = ObjectFactoryTest2.getInstace(Date.class);*/

//        ArrayTest.test();
        GenericTest.test();
    }
}
