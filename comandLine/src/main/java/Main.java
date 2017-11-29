import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// cd - перейти в диреторию, путь к которой задан первым аргументом
// dir - вывести список файлов в текущей директории
// pwd - вывести полный путь до текущей директории

public class Main {
    private static String command;
    private static List<String> arguments = new LinkedList<>();
    private static Integer sequencer = 0;

    public static void main(String[] args) throws IOException {
        while (true) {
            parseLine(new BufferedReader(new InputStreamReader(System.in)));
            switch (command) {
                case "dir":
                    DirCommand dir = new DirCommand();
                    dir.executeCommand();
                    break;
                case "cd":
                    CdCommand cd = new CdCommand();
                    cd.executeCommand();
                    sequencer++;
                    break;
                default:
                    System.out.println("Wrong command. Expected: command_name argument1, argument2.... argumentN ");
                    break;
            }
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
            arguments.add(tokenizer.nextToken());
        }
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
