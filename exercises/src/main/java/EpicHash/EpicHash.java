package EpicHash;

import java.util.*;

public class EpicHash<K, V> {
    private HashMap<K, SampleInt<V>> mainMap = new HashMap<K, SampleInt<V>>();
    private SampleMap<K, SampleInt<V>> mainObj = new SampleMap<>(mainMap);
    private LinkedList<SampleMap<K, SampleInt<V>>> objects = new LinkedList<>();
    private LinkedList<HashMap<K, SampleInt<V>>> maps = new LinkedList<>();
    private HashMap<K, SampleInt<V>> firstMap = new HashMap<K, SampleInt<V>>();
    private HashMap<K, SampleInt<V>> emptyMap = new HashMap<>();
    private SampleMap<K, SampleInt<V>> emptyObj = new SampleMap<K, SampleInt<V>>();
    private SampleMap<K, SampleInt<V>> firstObj = new SampleMap<>(emptyMap);
    private SampleInt<V> lazyObj = new SampleInt<V>();
    private Set<K> keys = new HashSet<>();


    public EpicHash() {
        objects.add(firstObj);
        maps.add(firstMap);
    }

    public void put(K key, V value) {
//        keys.add(key);
        emptyMap.put(key, lazyObj);
        for (int i = 0; i <maps.size() ; i++) {
            maps.get(i).put(key,lazyObj);
        }
        emptyObj.getMap().put(key,lazyObj);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).setMap(emptyMap);
        }
        mainObj.getMap().put(key, new SampleInt<V>(value));
    }

    public void putAll(V value) {
        lazyObj.setValue(value);
        HashMap<K, SampleInt<V>> newMap = new HashMap<K, SampleInt<V>>();
        keys.forEach(x->newMap.put(x,lazyObj));
        maps.add(newMap);
        mainMap=firstMap;
        Object[] objs = maps.toArray();
        for (int i = 0; i <objs.length ; i++) {
            objs[i]=objs[i+1];

        }


    }

    @Override
    public String toString() {
        return  mainObj.getMap() +"";
    }

    public V get(K key) {
        return (V) mainMap.get(key);
    }

    public static void main(String[] args) {
        EpicHash<String, Integer> hash = new EpicHash<String, Integer>();
        System.out.println();
        hash.put("test1", 0);
        hash.put("test2", 2);
        hash.put("test3", 3);
        hash.put("test4", 4);
        System.out.println(hash);
        hash.putAll(100500);
        System.out.println("ALL" + hash);
        hash.put("test1", 0);
        System.out.println(hash);
        hash.putAll(120);
        System.out.println("ALL" + hash);
        hash.put("test1", 0);
        System.out.println(hash);
        hash.putAll(9000);
        System.out.println("ALL" + hash);
    }
}