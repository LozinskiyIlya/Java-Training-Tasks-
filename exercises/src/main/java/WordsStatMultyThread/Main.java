package WordsStatMultyThread;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        HashMap<String, Integer> tokens = new HashMap<>();
        Map<String, Integer> syncTokens = Collections.synchronizedMap(tokens);
        Thread one = new Thread(new MyThread1(latch, syncTokens, "C:\\Users\\РС\\Desktop\\book1.txt"));
        Thread two = new Thread(new MyThread1(latch, syncTokens, "C:\\Users\\РС\\Desktop\\book2.txt"));
        one.start();
        two.start();
        latch.await();
        Object[] arr = new Main().getSortedMap(tokens);
        for (int i = 0; i < 20; i++) System.out.println(i + 1 + ") " + arr[i] + " ");

    }


    private Object[] getSortedMap(HashMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> toSort;
        toSort = map.entrySet();
        Object [] arr =  toSort.toArray();
        MyComparator comp = new MyComparator();
        Arrays.sort(arr, comp);
        return arr;
    }

    private static class MyComparator<E> implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (o1.getValue() > o2.getValue()) return -1;
            if (o1.getValue() < o2.getValue()) return 1;
            return 0;
        }
    }
}
