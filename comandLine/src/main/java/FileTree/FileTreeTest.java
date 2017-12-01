package FileTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileTreeTest {
    public static void main(String[] args) throws IOException {
        LinkedList<String> visited = walkTroughTheFileTree(parseLine());
        System.out.println();
        System.out.println(visited);
    }

    private static String parseLine() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу/каталогу");
        return input.readLine();
    }

    private static LinkedList<String> walkTroughTheFileTree(String input) {
        Path path = Paths.get(input).toAbsolutePath();
        System.out.println(path);
        List<String> visited = new LinkedList<>();
        visited.add(path.toString());
        if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println(path.getFileName());
        } else {
            String[] children = new File(path.toString()).list();
            String stopFactor = path.toString() + "\\" + children[children.length - 1];
            for (int i = 0; i < children.length; i++) {
                Path currentPath = Paths.get(path + "\\" + children[i]);
                if (visited.contains(currentPath.toString())) {
                    if (currentPath.toString().equals(stopFactor)) break;
                    if (i == children.length - 1) {
                        path = path.getParent();
                        children = new File(path.toString()).list();
                        i = -1;
                    }
                    continue;
                }
                visited.add(currentPath.toString());
                System.out.print(children[i] + " ");
                if (Files.isDirectory(currentPath, LinkOption.NOFOLLOW_LINKS)) {
                    System.out.println("->");
                    path = currentPath;
                    children = new File(path.toString()).list();
                    try {
                        if (children.length == 0) {
                            path = path.getParent();
                            children = new File(path.toString()).list();
                        }
                        i = -1;
                    } catch (NullPointerException e) {
                        path = path.getParent();
                        children = new File(path.toString()).list();
                        i = -1;
                    }
                } else if (i == children.length - 1) {
                    path = path.getParent();
                    children = new File(path.toString()).list();
                    i = -1;
                    System.out.println();
                }
            }
        }
        return (LinkedList<String>) visited;
    }
}
