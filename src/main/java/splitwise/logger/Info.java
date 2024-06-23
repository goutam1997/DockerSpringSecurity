package splitwise.logger;

public class Info extends MyLogger{
    Info(MyLogger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(MyLogLevel logLevel, String msg) {
        if (MyLogLevel.INFO == logLevel){
            System.out.println(logLevel.name()+": "+msg);
        }else {
            super.log(logLevel, msg);
        }
    }
}
