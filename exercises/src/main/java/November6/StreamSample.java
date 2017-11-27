package November6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamSample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(16);
        list.add(0);
        list.add(9);
        list.add(1);
        list.add(5);
        list.add(3);

        int[] arr = {16, 0, 9, 1, 5, 3};
       Arrays.stream(arr)
                .boxed()
                .sorted((x, y) -> y - x)
                .filter(x -> x < 10)
                .map(x -> x * -1)
                .limit(3)
                .parallel()
                .forEach(System.out::println);


    }
}
