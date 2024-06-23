package splitwise.file_structure;

public abstract class ListContents {
    protected String name;

    ListContents(String name){
        this.name=name;
    }

    public abstract void getName();
}
