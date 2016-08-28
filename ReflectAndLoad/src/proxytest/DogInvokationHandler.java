package proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by alpha on 16-8-25.
 */
public class DogInvokationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();
        du.method1();
        Object result = method.invoke(target, args);
        du.method2();
        return result;
    }
}
