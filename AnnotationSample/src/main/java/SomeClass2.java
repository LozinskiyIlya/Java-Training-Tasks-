

public class SomeClass2 {
    SomeClass someClass;

    public SomeClass2() {
        System.out.println("Called default constructor");
    }

    public SomeClass2(SomeClass someClass) {
        System.out.println("Called constructor with param");
        this.someClass = someClass;

    }
}
