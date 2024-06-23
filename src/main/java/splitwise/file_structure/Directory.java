package splitwise.file_structure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.List;

@ConditionalOnProperty(prefix = "hello", value = "on", havingValue = "off")
//@Autowired(required = false)
public class Directory extends ListContents {

    List<ListContents> listContents;

    Directory(String name, List<ListContents> listContents) {
        super(name);
        this.listContents=listContents;
    }

    @Override
    public void getName() {
        System.out.println("Directory: "+name);
        if (listContents==null){
            return;
        }
        for (ListContents listContent: listContents){
            listContent.getName();
        }
    }
}
