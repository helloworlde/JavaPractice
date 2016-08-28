package proxytest;

import java.lang.reflect.Proxy;

/**
 * Created by alpha on 16-8-25.
 */
public class MyProxyFactory {
    public static Object getProxy(Object target) {
        DogInvokationHandler handler = new DogInvokationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
