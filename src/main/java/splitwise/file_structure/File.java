package splitwise.file_structure;

public class File extends ListContents {

    File(String name) {
        super(name);
    }

    @Override
    public void getName() {
        System.out.println("File: " + name);
    }
}
