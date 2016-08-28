package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by alpha on 16-8-24.
 */

interface Person {
    void walk();

    void sayHello(String name);
}

class MyInvokationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行的方法——"+method);
        if (args != null) {
            System.out.println("传入的实参：");
            for (Object val :
                    args) {
                System.out.println(val);
            }
        } else {
            System.out.println("没有实参");
        }
        return null;
    }
}



public class ProxyTest {
    public static void test() {
        InvocationHandler handler = new MyInvokationHandler();
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        person.walk();
        person.sayHello("HelloWood");
    }
}
