package EpicHash;

public class SampleInt<A> {
   private A value;

    public SampleInt() {
    }

    public SampleInt(A value) {
        this.value = value;
    }

    public A getValue() {
        return value;
    }

    public void setValue(A value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
