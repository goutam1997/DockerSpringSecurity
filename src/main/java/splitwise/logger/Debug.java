package splitwise.logger;

public class Debug extends MyLogger{
    Debug(MyLogger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(MyLogLevel logLevel, String msg) {
        if (MyLogLevel.DEBUG == logLevel){
            System.out.println(logLevel.name()+": "+msg);
        }else {
            super.log(logLevel, msg);
        }
    }
}
