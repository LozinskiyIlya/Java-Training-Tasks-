package November5;

public class MyInterfaceSample {
    private interface MyInterface {
        void sayA(String b);
    }

    public static void useMyInterface(MyInterface myInterface) {
        myInterface.sayA("Hi!");
    }

    public static void main(String[] args) {
        useMyInterface(getLambda());
    }

    public static MyInterface getLambda() {
        return (System.out::println);
    }
}
