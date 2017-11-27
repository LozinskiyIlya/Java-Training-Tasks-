package EpicHashV1;

import java.util.HashMap;

public class Hash<K, V> {
    boolean wasPutAll;
    HashMap<K, SmartObj<V>> main = new HashMap<>();
    LazyObj<V> lazy = new LazyObj<>();

    public void put (K key, V val) {
        if(main.containsKey(key)){
            main.get(key).setWasPutAll(false);
        }
        main.put(key,new SmartObj<V>(val,false,lazy));
    }
    public void putAll(V val) {
        lazy.wasPutAll=true;
        lazy.value=val;
    }

    public V get(K key){
        return main.get(key).getValue();
    }

    @Override
    public String toString() {
       return main+"";
    }

    public static void main(String[] args) {
        Hash<String,Integer> test = new Hash<>();
        for (int i = 0; i <5 ; i++) {
            test.put("test"+i,i);
        }
        System.out.println(test);

        test.putAll(12);
        System.out.println(test);
        test.put("test1", 2);
        System.out.println(test);

    }
}
