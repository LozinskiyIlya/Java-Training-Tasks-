package EpicHash;

import java.util.HashMap;
import java.util.Set;

public class SampleMap <K,V>{
    private HashMap<K,V> map = new HashMap<K, V>();

    public SampleMap() {
    }

    public SampleMap(HashMap<K, V> map) {
        this.map = map;
    }

    public SampleMap(Set<K> keys, V value) {
        keys.forEach(x->map.put(x,value));
    }

    public HashMap<K, V> getMap() {
        return map;
    }

    public void setMap(HashMap<K, V> map) {
        this.map = map;
    }
}
