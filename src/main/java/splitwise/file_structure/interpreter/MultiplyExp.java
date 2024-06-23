package splitwise.file_structure.interpreter;

public class MultiplyExp extends AbstractExpression {

    private final AbstractExpression a;
    private final AbstractExpression b;

    MultiplyExp(AbstractExpression a, AbstractExpression b){
        this.a=a;
        this.b=b;
    }

    @Override
    public int interpret(Context context) {
        return a.interpret(context) * b.interpret(context);
    }
}
