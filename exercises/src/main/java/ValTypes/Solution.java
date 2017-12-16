package ValTypes;/*
Правильный ответ: d=1.0
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        HashMap<Character, char[][]> map = new HashMap<>();
        char[][] zero = getZero();
        map.put('0', zero);

        char[][] one = getOne();
        map.put('1', one);

        char[][] two = getTwo();
        map.put('2', two);

        char[][] three = getThree();
        map.put('3', three);

        char[][] four = getFour();
        map.put('4', four);

        char[][] five = getFive();
        map.put('5', five);

        char[][] six = getSix();
        map.put('6', six);

        char[][] seven = getSeven();
        map.put('7', seven);

        char[][] eight = getEight();
        map.put('8', eight);

        char[][] nine = getNine();
        map.put('9', nine);

        char[][] point = getPoint();
        map.put('.',point);


       while (true) {
            Scanner sc = new Scanner(System.in);
            char[] sequence = sc.nextLine().toCharArray();
            if (Arrays.equals(sequence, "Exit".toCharArray())) {
                break;
            }

            List<char[][]> numbers = new LinkedList<>();
            Iterator<char[][]> iterator = numbers.iterator();

            for (int i = 0; i < sequence.length; i++) {
                numbers.add(map.get(sequence[i]));
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    char[][] chars = numbers.get(j);
                    for (int k = 0; k < 7; k++) {
                        System.out.print(chars[i][k]);
                        if(k==6){
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }


    public static char[][] getPoint() {
        char[][] arr = new char[5][7];
        arr[4][3] = '*';
        return arr;
    }

    public static char[][] getZero() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 0 && j != 6) {
                    arr[i][j] = '*';
                } else if (i == 1 && (j == 0 || j == 6)) {
                    arr[i][j] = '*';

                } else if (i == 2 && (j == 0 || j == 6)) {
                    arr[i][j] = '*';

                } else if (i == 3 && (j == 0 || j == 6)) {
                    arr[i][j] = '*';

                } else if (i == 4 && j != 0 && j != 6) {
                    arr[i][j] = '*';

                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getOne() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 7; j++) {
                if (j == 4) {
                    arr[i][j] = '*';
                } else if (i == 1 && j == 2) {
                    arr[i][j] = '*';
                } else if (i == 4 && j != 0 && j != 1) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getTwo() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 7; j++) {
                if (i == 0 && (j == 3 || j == 4)) {
                    arr[i][j] = '*';
                } else if (i == 1) {
                    if (j == 6 || j == 1) {
                        arr[i][j] = '*';
                    } else {
                        arr[i][j] = ' ';
                    }
                } else if (i == 2) {
                    if (j == 4) {
                        arr[i][j] = '*';
                    } else {
                        arr[i][j] = ' ';
                    }
                } else if (j == 3 && i != 3) {
                    arr[i][j] = '*';
                } else if (i == 3 && j == 2) {
                    arr[i][j] = '*';
                } else if (i == 4 && j != 0) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getThree() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 0 && j != 6) {
                    arr[i][j] = '*';
                } else if (i == 1 && (j == 6)) {
                    arr[i][j] = '*';
                } else if (i == 2 && j != 0 && j != 1 && j != 6 && j != 2) {
                    arr[i][j] = '*';
                } else if (i == 3 && j == 6) {
                    arr[i][j] = '*';
                } else if (i == 4 && j != 0 && j != 6) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getFour() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && (j == 1 || j == 6)) {
                    arr[i][j] = '*';
                } else if (i == 1 && (j == 1 || j == 6)) {
                    arr[i][j] = '*';
                } else if (i == 2 && (j == 2 || j == 3 || j == 4 || j == 5 || j == 6)) {
                    arr[i][j] = '*';
                } else if (i == 3 && j == 6) {
                    arr[i][j] = '*';
                } else if (i == 4 && j == 6) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getFive() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 6 && j != 0) {
                    arr[i][j] = '*';
                } else if (i == 1 && j == 1) {
                    arr[i][j] = '*';
                } else if (i == 2 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) {
                    arr[i][j] = '*';
                } else if (i == 3 && j == 6) {
                    arr[i][j] = '*';
                } else if (i == 4 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getSix() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 6 && j != 0 && j != 1) {
                    arr[i][j] = '*';
                } else if (i == 1 && j == 1) {
                    arr[i][j] = '*';
                } else if (i == 2 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) {
                    arr[i][j] = '*';
                } else if (i == 3 && (j == 6 || j == 1)) {
                    arr[i][j] = '*';
                } else if (i == 4 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 5)) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getSeven() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 0) {
                    arr[i][j] = '*';
                } else if (i == 1) {
                    if (j == 5) {
                        arr[i][j] = '*';
                    } else {
                        arr[i][j] = ' ';
                    }
                } else if (i == 2) {
                    if (j == 3) {
                        arr[i][j] = '*';
                    } else {
                        arr[i][j] = ' ';
                    }
                } else if (j == 2) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getEight() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 0 && j != 6 && j != 1) {
                    arr[i][j] = '*';
                } else if (i == 1 && (j == 1 || j == 6)) {
                    arr[i][j] = '*';
                } else if (i == 2 && (j == 3 || j == 4)) {
                    arr[i][j] = '*';
                } else if (i == 4 && j != 0 && j != 6 && j != 1) {
                    arr[i][j] = '*';
                } else if (i == 3 && (j == 1 || j == 6)) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }

    public static char[][] getNine() {
        char[][] arr = new char[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j != 0 && j != 1) {
                    arr[i][j] = '*';
                } else if (i == 1 && (j == 1 || j == 6)) {
                    arr[i][j] = '*';
                } else if (i == 2 && j != 0 && j != 1) {
                    arr[i][j] = '*';
                } else if (i == 3 && j == 6) {
                    arr[i][j] = '*';
                } else if (i == 4 && j != 0 && j != 1) {
                    arr[i][j] = '*';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        return arr;
    }


    public static void printNumber(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}




