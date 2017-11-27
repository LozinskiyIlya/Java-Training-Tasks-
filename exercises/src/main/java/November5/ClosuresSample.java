package November5;

import java.util.function.Function;

public class ClosuresSample {
    public static void main(String[] args) {
        Function<Integer, Integer> func = getFunc(42);
        Function<Integer, Integer> func2 = getFunc(30);
        System.out.println(func.apply(5));
        System.out.println(func2.apply(5));
    }
    public static Function<Integer, Integer> getFunc (){
        return (Integer i)-> i+1;
    }

    public static Function<Integer, Integer> getFunc (int toAdd){

        return (Integer i)-> i+toAdd;
    }

}
