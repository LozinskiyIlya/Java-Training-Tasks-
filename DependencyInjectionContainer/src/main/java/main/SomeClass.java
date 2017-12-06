package main;


import First.SomeClass1;
import Second.SomeClass2;

public class SomeClass {
    private SomeClass1 i;
    private SomeClass2 s;
    private SomeClass3 t;
    public SomeClass4 f;

    public SomeClass(SomeClass1 i, SomeClass2 s) {
        this.i = i;
        this.s = s;
        System.out.println("called cons with params");
    }

    public void setT(main.SomeClass3 t) {
        this.t = t;
    }
}
