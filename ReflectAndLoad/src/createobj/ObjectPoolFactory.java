package createobj;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by alpha on 16-8-24.
 * 通过配置文件创建对象
 */
public class ObjectPoolFactory {

    private Map<String, Object> objectPool = new HashMap<>();

    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }

    public void initPool(String fileName) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties props = new Properties();
            props.load(fis);
            for (String name :
                    props.stringPropertyNames()) {
                objectPool.put(name, createObject(props.getProperty(name)));
            }
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }
}
