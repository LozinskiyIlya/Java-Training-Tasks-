import java.io.File;
import java.nio.file.Path;


// dir - вывести список файлов в текущей директории
public class DirCommand implements Command {

    private Path currentDir;

    public DirCommand(Path currentDir) {
        this.currentDir=currentDir;
    }

    public Path getArgument() {
        return currentDir;
    }

    @Override
    public void executeCommand() {
        File file = new File(currentDir.toString());
        if (file.isDirectory()) {
            String[] children = file.list();
            if(children==null ||children.length==0){
                System.out.println("Directory is empty");
                return;
            }
            for (int i = 0; i < children.length; i++) {
                System.out.print(children[i] + " ");
            }
        } else {
            System.out.println("It is a file, not a directory");
        }
    }

    @Override
    public boolean success() {
        return false;
    }
}
