import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


// cd - перейти в диреторию, путь к которой задан первым аргументом
public class CdCommand implements Command {

    private Path currentDir;
    private boolean success;

    public CdCommand(Path currentDir) {
        this.currentDir = currentDir;
    }

    public void setCurrentDir(Path currentDir) {
        this.currentDir = currentDir;
    }

    public Path getCurrentDir() {
        return currentDir;
    }

    @Override
    public void executeCommand() {
        if (!Files.exists(currentDir)) {
            System.out.println("Wrong argument. File/Directory does not exist");
            currentDir=currentDir.getParent();
        }
        System.out.println("You are now at: " + currentDir);
        success = true;
    }

    @Override
    public boolean success() {
        return success;
    }
}
