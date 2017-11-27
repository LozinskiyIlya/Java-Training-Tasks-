package WordsStatFunctionalStyle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        getWordsV2()
                .filter(word->word.length()>3)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(x1 -> x1, Collectors.counting()))
                .entrySet().stream()
                .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .limit(20)
                .forEach(System.out::println);


    }

    private static Stream<String> getWords() {
        return Arrays.stream(new String[]{"a", "a", "a", "b", "b", "c", "qwe", "abc"});
    }

    private static Stream<String> getWordsV2() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("C:\\Users\\РС\\Desktop\\book1.txt");
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buffer = new BufferedReader(reader);
        return buffer
                .lines()
                .flatMap((line -> Arrays.stream(line.split(" "))));

    }

    private static Map<String, Integer> getFrequencies(Stream<String> words) {
        Map<String, Integer> result = new HashMap<>();
        List<String> wordsList = words.collect(Collectors.toList());
        for (String word : wordsList) {
            if (result.containsKey(word)) {
                int value = (result.get(word) + 1);
                result.put(word, value);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }

    public static void getFreqV2(Stream<String> words) {
        Map<String, Integer> result =
                words.collect(Collectors.groupingBy(word -> word)).entrySet()
                        .stream().map(group -> new MyGroup(group.getKey(), group.getValue().size()))
                        .collect(Collectors.toMap(x -> x.key, x -> x.freq));
        System.out.println(result);
    }

    public static Map<String, Long> getFreqV3(Stream<String> words) {
        Map<String, Long> result = words.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        return result;
    }
}

class MyGroup {
    String key;
    Integer freq;

    public MyGroup(String key, Integer freq) {
        this.key = key;
        this.freq = freq;
    }
}
