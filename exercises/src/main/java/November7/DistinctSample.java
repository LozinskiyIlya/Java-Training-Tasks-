package November7;

import October31.Synchro;

import java.util.Arrays;

public class DistinctSample {
    public static void main(String[] args) {
        int[] elements ={-1,-1,-1,-1,3,4,-5,5};
        boolean b = Arrays.stream(elements).anyMatch(x -> x>=0);
        System.out.println(b);
    }
}
