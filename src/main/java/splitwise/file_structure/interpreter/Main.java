package splitwise.file_structure.interpreter;

public class Main {
    public static void main(String[] args) {
        Context context=new Context();
        context.put("a", 2);
        context.put("b", 3);
        context.put("c", 6);
        context.put("d", 9);

        //((a+b) * (c+d))
        AbstractExpression abstractExpression = new MultiplyExp(
                new SumExp(new TerminalExp("a"), new TerminalExp("b")),
                new SumExp(new TerminalExp("c"), new TerminalExp("d")));
        System.out.println(abstractExpression.interpret(context));
    }
}
