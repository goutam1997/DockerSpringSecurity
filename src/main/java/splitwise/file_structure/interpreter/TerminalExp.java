package splitwise.file_structure.interpreter;

public class TerminalExp extends AbstractExpression {

    private String key;
    TerminalExp(String key){
        this.key=key;
    }
    @Override
    public int interpret(Context context) {
        return context.get(key);
    }
}
