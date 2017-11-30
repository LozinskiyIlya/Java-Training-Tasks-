import java.io.File;
import java.util.List;



// cd - перейти в диреторию, путь к которой задан первым аргументом
public class CdCommand implements Command {

    private String argument;
    private String currentDirectory;

    public CdCommand(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    @Override
    public void executeCommand() {
        File file = new File(currentDirectory);
        String[] children = file.list();
//        if()
        System.out.println("You are now in: " + argument);
    }
}
