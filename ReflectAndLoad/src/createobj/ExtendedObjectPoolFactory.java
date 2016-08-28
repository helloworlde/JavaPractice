package createobj;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by alpha on 16-8-24.
 * 通过配置文件创建对象并调用方法
 */
public class ExtendedObjectPoolFactory {
    private Map<String, Object> objectPool = new HashMap<>();
    private Properties config = new Properties();

    public void init(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)){
            config.load(fis);
        }
    }

    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }

    public void initPoll() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (String name :
                config.stringPropertyNames()) {
            if (!name.contains("%")) {
                objectPool.put(name, createObject(config.getProperty(name)));
            }
        }
    }

    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (String name :
                config.stringPropertyNames()) {
            if (name.contains("%")) {
                String[] objAndProp = name.split("%");
                Object target = getObject(objAndProp[0]);
                String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() + objAndProp[1].substring(1);
                Class<?> targetClass = target.getClass();
                Method mtd = targetClass.getMethod(mtdName, String.class);
                mtd.invoke(target, config.getProperty(name));
            }
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }
}
