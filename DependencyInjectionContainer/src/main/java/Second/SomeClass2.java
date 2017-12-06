package Second;
import main.Serv;
import main.SomeClass5;


@Serv
public class SomeClass2 implements Second {
    public SomeClass2(SomeClass5 t) {
        System.out.println("SomeClass2 created");
    }
}
