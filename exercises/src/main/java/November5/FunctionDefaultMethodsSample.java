package November5;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionDefaultMethodsSample {
    public static void main(String[] args) {
        Function<Integer,String> first = Object::toString;
        Function<String , Boolean> second = (String s)->s.length()>3;

        Function<Integer, Boolean> thirdV2 = first.andThen(second);

        Consumer<Object> println = System.out::println;
        println.accept(123);

        Supplier<MyClass> creator = MyClass::new;
        println.accept(creator.get());
    }
    private static class MyClass{
        public MyClass() {
        }
    }
}
