package EpicHashV1;

public class SmartObj<V> {
    V value;
    boolean wasPutAll;
    LazyObj lazyObj;

    public SmartObj() {
    }

    public SmartObj(V value, boolean wasPutAll, LazyObj lazyObj) {
        this.value = value;
        this.wasPutAll = wasPutAll;
        this.lazyObj = lazyObj;
    }

    public void setWasPutAll(boolean wasPutAll) {
        if (this.wasPutAll==lazyObj.wasPutAll) {
            this.wasPutAll = lazyObj.isWasPutAll();
        }else{
            this.wasPutAll= false;
        }
    }

    public V getValue() {
        if(this.wasPutAll==true){
            return (V) lazyObj.value;
        }
        return this.value;
    }

    @Override
    public String toString() {
        return getValue()+"";
    }
}
