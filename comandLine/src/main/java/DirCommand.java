import java.io.File;


// dir - вывести список файлов в текущей директории
public class DirCommand implements Command {

    private String argument;

    public DirCommand(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public void executeCommand() {
        File file = new File(argument);
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++) {
                System.out.print(children[i] + " ");
            }
        } else {
            System.out.println("It is a file, not a directory");
        }
    }
}
