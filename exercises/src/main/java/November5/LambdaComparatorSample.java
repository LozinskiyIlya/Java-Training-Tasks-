package November5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaComparatorSample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);
        list.sort((o1, o2) -> o2 - o1);
    }
}
