package splitwise.file_structure;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Directory d2=new Directory("d2", null);
        File f1=new File("f1");
        File f2=new File("f2");
        Directory d3=new Directory("d3", Arrays.asList(d2, f1, f2));
        d3.getName();

        File file=new File("file");
        file.getName();
        d2.getName();
    }
}
