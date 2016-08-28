package talk;

import java.util.*;

/**
 * Created by alpha on 16-8-9.
 */
public class DefinedMap<K, V> {
    public Map<K, V> map = Collections.synchronizedMap(new HashMap<K, V>());

    public synchronized void removeByValue(Object value) {
        for (Object key : map.keySet()) {
            if (map.get(key) == value) {
                map.remove(key);
                break;
            }
        }
    }

    public synchronized Set<V> valueSet() {
        Set<V> result = new HashSet<V>();
        map.forEach((key,value)->result.add(value));
        return result;
    }

    public synchronized K getKeyByValue(V val) {
        for (K key :
                map.keySet()) {
            if (map.get(key) == val || map.get(key).equals(val)) {
                return key;
            }
        }
        return null;
    }

    public synchronized V put(K key, V value) {
        for (V val :
                valueSet()) {
            if (val.equals(val)&&val.hashCode() == value.hashCode()) {
                throw new RuntimeException("Map实例中不允许有重复value");
            }
        }
        return map.put(key, value);
    }
}
