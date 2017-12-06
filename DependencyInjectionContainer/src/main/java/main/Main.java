package main;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Container container = new Container();
        SomeClass cl = (SomeClass) container.getInstance(SomeClass.class);
    }
}
