package FileTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class FileTreeRecursive {
    public static void main(String[] args) throws IOException {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<String> visited = walk(Paths.get(parseLine()), result);
        System.out.println();
        System.out.println(visited);
    }

    private static LinkedList<String> walk(Path path, LinkedList<String> result) {
        String[] children = new File(path.toString()).list();
        if (children == null) {
            result.add(path.toString());
            return result;
        }
        for (int i = 0; i < children.length; i++) {
            if (result.contains(path + "\\" + children[i])) {
                continue;
            }
            result.add(path + "\\" + children[i]);
            System.out.println(children[i]);
            if (Files.isDirectory(Paths.get(path.toString() + "\\" + children[i]))) {
                walk(Paths.get(path.toString() + "\\" + children[i]), result);
            }
        }
        return result;
    }

    private static String parseLine() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу/каталогу");
        return input.readLine();
    }
}
