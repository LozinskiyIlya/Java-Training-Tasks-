package November2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SafeColl {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(list);

        synchronized (syncList) {
            for (Integer i : syncList) {
                System.out.println(i);
            }
        }
    }

}
