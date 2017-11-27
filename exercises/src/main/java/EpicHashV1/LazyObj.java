package EpicHashV1;

public class LazyObj<V>{
    V value;
    boolean wasPutAll = true;

    public LazyObj() {
    }

    public LazyObj(boolean wasPutAll) {
        this.wasPutAll = wasPutAll;
    }

    public LazyObj(V value, boolean wasPutAll) {
        this.value = value;
        this.wasPutAll = wasPutAll;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isWasPutAll() {
        return wasPutAll;
    }

    public void setWasPutAll(boolean wasPutAll) {
        this.wasPutAll = wasPutAll;
    }
}

