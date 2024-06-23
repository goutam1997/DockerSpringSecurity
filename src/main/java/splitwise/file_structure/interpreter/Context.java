package splitwise.file_structure.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<String, Integer> context=new HashMap<>();

    public void put(String a, int value){
        context.put(a, value);
    }
    public int get(String key){
        return context.get(key);
    }
}
