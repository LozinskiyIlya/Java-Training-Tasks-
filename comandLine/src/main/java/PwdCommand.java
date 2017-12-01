import java.nio.file.Path;

// pwd - вывести полный путь до текущей директории
public class PwdCommand implements Command {
    private Path currentDir;

    public PwdCommand(Path currentDir) {
        this.currentDir = currentDir;
    }

    @Override
    public void executeCommand() {
        System.out.println(currentDir);
    }

    @Override
    public boolean success() {
        return false;
    }
}
