package WordsStatMultyThread;

import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class MyThread1 implements Runnable {

    private BufferedReader reader;
    private CountDownLatch latch;
    private Map<String, Integer> tokens;


    MyThread1(CountDownLatch latch, Map<String, Integer> tokens, String way) throws FileNotFoundException {
        this.latch = latch;
        this.tokens = tokens;
        FileInputStream in = new FileInputStream(way);
        reader = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public void run() {
        StringTokenizer tokenizer;
        try {
            String line;
            while (true) {
                int b = reader.read();
                if (b == -1) {
                    latch.countDown();
                    System.out.println("");
                    break;
                }
                if (b == 13) continue;
                line = reader.readLine();
                try {
                    tokenizer = new StringTokenizer(line, "?><!,./;:-\"\'(){}[] _");
                } catch (NullPointerException e) {
                    continue;
                }
                for (int i = 0; i < tokenizer.countTokens(); i++) {
                    String tmpToken = tokenizer.nextToken().toLowerCase();
                    if (tmpToken.equals(" -") || tmpToken.length() == 1 || tmpToken.length() == 2
                            || tmpToken.length() == 3 || tmpToken.equals("")) continue;
                    if (tokens.containsKey(tmpToken)) {
                        int tmpCount = tokens.get(tmpToken);
                        tokens.replace(tmpToken, tmpCount + 1);
                    } else {
                        tokens.put(tmpToken, 1);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

