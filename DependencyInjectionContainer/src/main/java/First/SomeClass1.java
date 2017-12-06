package First;

import Second.SomeClass2;
import main.MAO;
import main.SomeClass3;
import main.SomeClass5;

@MAO
public class SomeClass1 implements First {
    public SomeClass1(SomeClass5 t) {
        System.out.println("SomeClass1 created");
    }
}
