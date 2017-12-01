import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// cd - перейти в диреторию, путь к которой задан первым аргументом
// dir - вывести список файлов в текущей директории
// pwd - вывести полный путь до текущей директории

public class Main {
    private static String command;
    private static String argument;
    private static CdCommand cd;
    private static DirCommand dir;
    private static PwdCommand pwd;
    private static Path currentDir;


    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            processCommands(input);
        }

    }

    private static void processCommands(BufferedReader input) throws IOException {
        parseLine(input);
        switch (command) {
            case "cd":
                if (currentDir == null) {
                    try {
                        currentDir = Paths.get(argument);
                    }catch (InvalidPathException e){
                        System.out.println("Invalid path");
                        break;
                    }
                    cd = new CdCommand(currentDir);
                    cd.executeCommand();
                } else {
                    List<String> children = Arrays.asList(new File(currentDir.toString()).list());
                    if (children != null && children.contains(argument)) {
                        currentDir = Paths.get(currentDir.toString() + "\\" + argument);
                        cd.setCurrentDir(currentDir);
                        cd.executeCommand();
                    }else{
                        try {
                            cd.setCurrentDir(Paths.get(argument));
                        }catch (InvalidPathException e){
                            System.out.println("Invalid path");
                            cd.setCurrentDir(currentDir);
                            break;
                        }
                        cd.executeCommand();
                    }
                }
                break;
            case "dir":
                if(cd==null){
                    break;
                } else if(cd.getCurrentDir()!=null) {
                    dir = new DirCommand(cd.getCurrentDir());
                }else {
                    dir = new DirCommand(currentDir);
                }
                dir.executeCommand();
                break;
            case "pwd":
                if(cd==null){
                    break;
                } else if(cd.getCurrentDir()!=null) {
                    pwd = new PwdCommand(cd.getCurrentDir());
                }else {
                    pwd = new PwdCommand(currentDir);
                }
                pwd.executeCommand();
                break;
            case "!Exit":
                System.out.println("Goodbye......");
                System.exit(1);
            default:
                System.out.println("Wrong command");
                break;
        }
    }

    private static void parseLine(BufferedReader reader) throws IOException {
        String received = validateInput(reader);
        if (received.equals("dir") || received.equals("pwd")) {
            command = received;
            return;
        }
        command = received.substring(0, received.indexOf(' '));
        String ars = received.substring(command.length() + 1, received.length());
        StringTokenizer tokenizer = new StringTokenizer(ars, " ");
        while (tokenizer.hasMoreTokens()) {
            // TODO: change String to Collection(List)
            // arguments.add(tokenizer.nextToken());
            argument = tokenizer.nextToken();
        }
        System.out.println(command);
        System.out.println(argument);
    }

    private static String validateInput(BufferedReader reader) throws IOException {
        String received = "";
        boolean badCommand = false;
        while (!badCommand) {
            received = reader.readLine();
            if (received.equals("dir") || received.equals("pwd")) return received;
            if (received.equals("")) {
                System.out.println("Empty command");
            } else if (!received.contains(" ") || received.indexOf(' ') == received.length() - 1) {
                System.out.println("Wrong argument. Expected: command_name argument1, argument2.... argumentN ");
            } else {
                badCommand = true;
            }
        }
        return received;
    }
}
